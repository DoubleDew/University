from __future__ import annotations

import json
import re
import uuid
from datetime import datetime
from typing import Any, Dict, Optional
from urllib import request


class StructuringError(RuntimeError):
    pass


ISSUE_KEYWORDS = [
    "lethargic",
    "limping",
    "cough",
    "fever",
    "mastitis",
    "low appetite",
    "reduced milk",
    "diarrhea",
    "lameness",
]


def _extract_issues(text: str) -> list[str]:
    lowered = text.lower()
    return [kw for kw in ISSUE_KEYWORDS if kw in lowered]


def _extract_number(pattern: str, text: str) -> Optional[float]:
    match = re.search(pattern, text, flags=re.IGNORECASE)
    if not match:
        return None
    try:
        return float(match.group(1))
    except ValueError:
        return None


def _rule_based_structuring(transcript: str) -> Dict[str, Any]:
    year_match = re.search(r"\b(19|20)\d{2}\b", transcript)
    year = int(year_match.group(0)) if year_match else None
    cow_match = re.search(r"\bcow\s+(\d+)\b", transcript, flags=re.IGNORECASE)
    cow_id = cow_match.group(1) if cow_match else None

    pta_milk = _extract_number(r"pta\s*milk\s*([-+]?\d+(\.\d+)?)", transcript)
    reliability = _extract_number(r"reliability\s*([-+]?\d+(\.\d+)?)", transcript)
    num_records = _extract_number(
        r"(?:num|number)\s*records\s*([-+]?\d+(\.\d+)?)", transcript
    )
    gen_interval = _extract_number(r"generation\s*interval\s*([-+]?\d+(\.\d+)?)", transcript)

    issues = _extract_issues(transcript)

    observed_at = None
    if year is not None:
        observed_at = f"{year}-01-01"

    metrics = {}
    if pta_milk is not None:
        metrics["pta_milk"] = pta_milk
    if reliability is not None:
        metrics["reliability"] = reliability
    if num_records is not None:
        metrics["num_records"] = int(num_records)
    if gen_interval is not None:
        metrics["generation_interval"] = gen_interval

    return {
        "entry_id": str(uuid.uuid4()),
        "observed_at": observed_at,
        "cow_id": cow_id,
        "herd_group": "Holstein",
        "observation": transcript.strip(),
        "issues": issues,
        "metrics": metrics,
        "structured_at": datetime.utcnow().isoformat() + "Z",
        "source": "rule_based",
    }


def _parse_json_response(raw: str) -> Dict[str, Any]:
    if not raw.strip():
        raise StructuringError("LLM returned an empty response.")
    try:
        return json.loads(raw)
    except json.JSONDecodeError:
        pass

    match = re.search(r"\{.*\}", raw, flags=re.DOTALL)
    if match:
        try:
            return json.loads(match.group(0))
        except json.JSONDecodeError:
            pass

    raise StructuringError("LLM did not return valid JSON.")


def _ollama_structuring(transcript: str, model: str) -> Dict[str, Any]:
    prompt = (
        "Return only valid JSON with keys: "
        "observed_at (YYYY-MM-DD or null), cow_id, herd_group, "
        "observation, issues (list), metrics (object). "
        "If data is missing, use null or empty list/object. "
        f"Text: {transcript}"
    )

    payload = json.dumps(
        {
            "model": model,
            "prompt": prompt,
            "stream": False,
            "format": "json",
        }
    ).encode("utf-8")

    try:
        req = request.Request(
            "http://localhost:11434/api/generate",
            data=payload,
            headers={"Content-Type": "application/json"},
        )
        with request.urlopen(req, timeout=60) as resp:
            data = json.load(resp)
    except Exception as exc:
        raise StructuringError(
            "Failed to reach local Ollama server. Ensure ollama is running."
        ) from exc

    raw = data.get("response", "").strip()
    parsed = _parse_json_response(raw)

    parsed["entry_id"] = str(uuid.uuid4())
    parsed["structured_at"] = datetime.utcnow().isoformat() + "Z"
    parsed["source"] = f"ollama:{model}"
    return parsed


def structure_transcript(
    transcript: str, mode: str = "rule_based", model: str = "llama3"
) -> Dict[str, Any]:
    if mode == "ollama":
        return _ollama_structuring(transcript, model=model)
    if mode == "rule_based":
        return _rule_based_structuring(transcript)
    raise StructuringError(f"Unknown mode: {mode}")
