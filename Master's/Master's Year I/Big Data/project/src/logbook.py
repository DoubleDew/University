from __future__ import annotations

import json
from pathlib import Path
from src.ledger import build_chain
from typing import Any, Dict, Iterable
from .config import LOGBOOK_CSV, LOGBOOK_PARQUET, PROCESSED_DIR

LEDGER_JSONL = PROCESSED_DIR / "ledger.jsonl"

def write_ledger_jsonl(entries, ledger_path: Path) -> None:
    ledger = build_chain(entries)
    ledger_path.parent.mkdir(parents=True, exist_ok=True)
    with ledger_path.open("w", encoding="utf-8") as f:
        for rec in ledger:
            f.write(json.dumps(rec, ensure_ascii=False) + "\n")

def _normalize_issues(issues: Any) -> list[str]:
    if issues is None:
        return []
    if isinstance(issues, str):
        return [issues]
    if isinstance(issues, dict):
        return [str(issues)]
    if not isinstance(issues, list):
        return [str(issues)]

    normalized: list[str] = []
    for item in issues:
        if isinstance(item, str):
            normalized.append(item)
        elif isinstance(item, dict):
            label = item.get("issue") or item.get("label") or item.get("name")
            normalized.append(str(label) if label is not None else str(item))
        else:
            normalized.append(str(item))
    return normalized


def _entry_to_row(entry: Dict[str, Any]) -> Dict[str, Any]:
    metrics = entry.get("metrics") or {}
    issues = _normalize_issues(entry.get("issues"))
    return {
        "entry_id": entry.get("entry_id"),
        "observed_at": entry.get("observed_at"),
        "cow_id": entry.get("cow_id"),
        "herd_group": entry.get("herd_group"),
        "observation": entry.get("observation"),
        "issues": ";".join(issues),
        "pta_milk": metrics.get("pta_milk"),
        "reliability": metrics.get("reliability"),
        "num_records": metrics.get("num_records"),
        "generation_interval": metrics.get("generation_interval"),
        "structured_at": entry.get("structured_at"),
        "source": entry.get("source"),
    }


def append_entries(entries: Iterable[Dict[str, Any]]) -> str:
    PROCESSED_DIR.mkdir(parents=True, exist_ok=True)
    rows = [_entry_to_row(e) for e in entries]
    if not rows:
        return "No entries to write."

    try:
        import pandas as pd
    except Exception as exc:
        raise RuntimeError("pandas is required to write the logbook.") from exc

    df = pd.DataFrame(rows)

    if LOGBOOK_PARQUET.exists():
        existing = pd.read_parquet(LOGBOOK_PARQUET)
        df = pd.concat([existing, df], ignore_index=True)

    full_entries = df.to_dict(orient="records")
    write_ledger_jsonl(full_entries, LEDGER_JSONL)

    try:
        df.to_parquet(LOGBOOK_PARQUET, index=False)
        return str(LOGBOOK_PARQUET)
    except Exception:
        df.to_csv(LOGBOOK_CSV, index=False)
        return str(LOGBOOK_CSV)

        
