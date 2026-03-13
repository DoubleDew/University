# src/ledger.py
from __future__ import annotations

import hashlib
import json
from typing import Any, Dict, Iterable, List, Optional

def _json_safe(x):
    # Local import so the project still runs if numpy isn't installed in some mode
    try:
        import numpy as np
    except Exception:
        np = None

    if x is None:
        return None

    # numpy scalar -> python scalar
    if np is not None:
        if isinstance(x, np.generic):
            return x.item()
        # numpy array -> list
        if isinstance(x, np.ndarray):
            return x.tolist()

    if isinstance(x, dict):
        return {str(k): _json_safe(v) for k, v in x.items()}
    if isinstance(x, list):
        return [_json_safe(v) for v in x]

    return x


GENESIS_HASH = "0" * 64

# Choose which fields define the "block content".
# Exclude volatile fields if you want stable hashes (e.g. structured_at changes each run).
CHAIN_FIELDS = [
    "entry_id",
    "observed_at",
    "cow_id",
    "herd_group",
    "observation",
    "issues",
    "pta_milk",
    "reliability",
    "num_records",
    "generation_interval",
    "source",
]

def _canonicalize(value: Any) -> Any:
    """Normalize values so hashing is stable across runs/platforms."""
    if value is None:
        return None
    if isinstance(value, float):
        # Avoid float representation differences
        return float(f"{value:.10g}")
    if isinstance(value, (list, tuple)):
        return [_canonicalize(v) for v in value]
    if isinstance(value, dict):
        return {k: _canonicalize(value[k]) for k in sorted(value.keys())}
    return value

def canonical_entry(entry: Dict[str, Any]) -> Dict[str, Any]:
    """Pick stable fields and return a canonical dict."""
    data: Dict[str, Any] = {}
    for k in CHAIN_FIELDS:
        data[k] = _canonicalize(entry.get(k))
    return data

def hash_block(prev_hash: str, entry: Dict[str, Any]) -> str:
    payload = {
        "prev_hash": prev_hash,
        "entry": canonical_entry(entry),
    }
    # Deterministic JSON bytes
    payload = _json_safe(payload)
    b = json.dumps(payload, sort_keys=True, separators=(",", ":"), ensure_ascii=False).encode("utf-8")
    return hashlib.sha256(b).hexdigest()

def build_chain(entries: List[Dict[str, Any]], start_prev: str = GENESIS_HASH) -> List[Dict[str, Any]]:
    """Return ledger records (one per entry) with prev_hash and hash."""
    prev = start_prev
    ledger: List[Dict[str, Any]] = []
    for e in entries:
        h = hash_block(prev, e)
        ledger.append({
            "entry_id": e.get("entry_id"),
            "prev_hash": prev,
            "hash": h,
        })
        prev = h
    return ledger