from __future__ import annotations

import json
from pathlib import Path
from typing import Any, Dict, List

from src.ledger import GENESIS_HASH, hash_block

def read_logbook_records() -> List[Dict[str, Any]]:
    import pandas as pd

    parquet_path = Path("data/processed/logbook.parquet")
    csv_path = Path("data/processed/logbook.csv")

    if parquet_path.exists():
        df = pd.read_parquet(parquet_path)
    elif csv_path.exists():
        df = pd.read_csv(csv_path)
    else:
        raise SystemExit(f"Missing both {parquet_path} and {csv_path}")

    return df.where(df.notna(), None).to_dict(orient="records")

def read_ledger_jsonl(path: Path) -> List[Dict[str, Any]]:
    out: List[Dict[str, Any]] = []
    with path.open("r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line:
                out.append(json.loads(line))
    return out

def main() -> None:
    ledger_jsonl = Path("data/processed/ledger.jsonl")
    if not ledger_jsonl.exists():
        raise SystemExit(f"Missing {ledger_jsonl}. Run pipeline once to generate it.")

    entries = read_logbook_records()
    ledger = read_ledger_jsonl(ledger_jsonl)

    if len(entries) != len(ledger):
        raise SystemExit(f"Length mismatch: entries={len(entries)} ledger={len(ledger)}")

    prev = GENESIS_HASH
    for i, (e, rec) in enumerate(zip(entries, ledger), start=1):
        expected = hash_block(prev, e)
        if rec.get("prev_hash") != prev or rec.get("hash") != expected:
            raise SystemExit(
                f"CHAIN BROKEN at row {i}\n"
                f"expected prev={prev}\n"
                f"ledger  prev={rec.get('prev_hash')}\n"
                f"expected hash={expected}\n"
                f"ledger   hash={rec.get('hash')}"
            )
        prev = expected

    print(f"OK: chain verified ({len(entries)} blocks). Last hash={prev}")

if __name__ == "__main__":
    main()