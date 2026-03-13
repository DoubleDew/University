from __future__ import annotations

from pathlib import Path

import pandas as pd

from src.config import RAW_DATA, SYNTHETIC_DIR


def main() -> None:
    df = pd.read_csv(RAW_DATA, na_values=["#N/A", "NA", "N/A"])

    year_col = "yob1"
    pta_col = "W_HO_PTA_m_SB"
    rel_col = "W_HO_REL_m_SB"
    num_col = "W_HO_NUM_PTA_SB"
    gi_col = "GenInt_SB"

    transcripts = []
    for _, row in df.iterrows():
        year = row.get(year_col)
        if pd.isna(year):
            continue

        parts = [f"Year {int(year)}: Holstein cohort."]

        pta = row.get(pta_col)
        if not pd.isna(pta):
            parts.append(f"PTA milk {pta:.2f}.")
        rel = row.get(rel_col)
        if not pd.isna(rel):
            parts.append(f"Reliability {rel:.2f}.")
        num = row.get(num_col)
        if not pd.isna(num):
            parts.append(f"Num records {int(num)}.")
        gi = row.get(gi_col)
        if not pd.isna(gi):
            parts.append(f"Generation interval {gi:.2f}.")

        # Simple heuristic to inject health-style phrases for parsing tests.
        if not pd.isna(pta) and pta < -1000:
            parts.append("Noticed reduced milk output.")
        if not pd.isna(rel) and rel < 0.95:
            parts.append("Cow group appears lethargic.")

        transcripts.append(" ".join(parts))

    SYNTHETIC_DIR.mkdir(parents=True, exist_ok=True)
    out_path = SYNTHETIC_DIR / "transcripts.txt"
    out_path.write_text("\n".join(transcripts), encoding="utf-8")
    print(f"Wrote {len(transcripts)} transcripts to {out_path}")


if __name__ == "__main__":
    main()
