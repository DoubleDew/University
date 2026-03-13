from __future__ import annotations

import sys
from pathlib import Path

import pandas as pd

if __package__ in (None, ""):
    # Allow running as a script: python src/analysis.py
    sys.path.append(str(Path(__file__).resolve().parents[1]))
    from src.config import LOGBOOK_CSV, LOGBOOK_PARQUET, RAW_DATA, ASSETS_DIR
else:
    from .config import LOGBOOK_CSV, LOGBOOK_PARQUET, RAW_DATA, ASSETS_DIR


def _load_logbook() -> pd.DataFrame:
    if LOGBOOK_PARQUET.exists() and LOGBOOK_CSV.exists():
        parquet_mtime = LOGBOOK_PARQUET.stat().st_mtime
        csv_mtime = LOGBOOK_CSV.stat().st_mtime
        if csv_mtime > parquet_mtime:
            return pd.read_csv(LOGBOOK_CSV)
        return pd.read_parquet(LOGBOOK_PARQUET)
    if LOGBOOK_PARQUET.exists():
        return pd.read_parquet(LOGBOOK_PARQUET)
    if LOGBOOK_CSV.exists():
        return pd.read_csv(LOGBOOK_CSV)
    raise FileNotFoundError("Logbook not found. Run the pipeline first.")


def _percent(series: pd.Series) -> float:
    if len(series) == 0:
        return 0.0
    return float(series.mean()) * 100.0


def _issues_count(series: pd.Series) -> pd.Series:
    return series.fillna("").astype(str).apply(
        lambda x: 0 if x.strip() == "" else len([i for i in x.split(";") if i.strip()])
    )


def _filled_fields(df: pd.DataFrame) -> pd.Series:
    fields = [
        "observed_at",
        "cow_id",
        "pta_milk",
        "reliability",
        "num_records",
        "generation_interval",
    ]
    counts = df[fields].notna().sum(axis=1)
    counts += _issues_count(df["issues"]).gt(0).astype(int)
    return counts


def main() -> None:
    ASSETS_DIR.mkdir(parents=True, exist_ok=True)

    logbook = _load_logbook()
    raw = pd.read_csv(RAW_DATA, na_values=["#N/A", "NA", "N/A"])

    metrics = []
    metrics.append(("entries_total", len(logbook)))
    metrics.append(("pct_with_observed_at", _percent(logbook["observed_at"].notna())))
    metrics.append(("pct_with_pta_milk", _percent(logbook["pta_milk"].notna())))
    metrics.append(("pct_with_reliability", _percent(logbook["reliability"].notna())))
    metrics.append(("pct_with_num_records", _percent(logbook["num_records"].notna())))
    metrics.append(("pct_with_generation_interval", _percent(logbook["generation_interval"].notna())))
    metrics.append(("pct_with_issues", _percent(logbook["issues"].fillna("").str.len() > 0)))

    pta = logbook["pta_milk"].dropna()
    rel = logbook["reliability"].dropna()
    num = logbook["num_records"].dropna()

    metrics.append(("pta_milk_mean", float(pta.mean()) if not pta.empty else 0.0))
    metrics.append(("reliability_mean", float(rel.mean()) if not rel.empty else 0.0))
    metrics.append(("num_records_mean", float(num.mean()) if not num.empty else 0.0))

    outlier_pta = ((pta < -4000) | (pta > 4000)).sum() if not pta.empty else 0
    outlier_rel = ((rel < 0) | (rel > 1)).sum() if not rel.empty else 0
    metrics.append(("pta_milk_outliers", int(outlier_pta)))
    metrics.append(("reliability_outliers", int(outlier_rel)))

    # LLM/source metrics
    logbook["source"] = logbook["source"].fillna("unknown")
    source_counts = logbook["source"].value_counts().reset_index()
    source_counts.columns = ["source", "entries"]
    source_counts.to_csv(ASSETS_DIR / "llm_source_counts.csv", index=False)

    total_entries = len(logbook)
    llm_entries = logbook["source"].str.startswith("ollama:").sum()
    metrics.append(("llm_entries", int(llm_entries)))
    metrics.append(("llm_pct", (llm_entries / total_entries * 100.0) if total_entries else 0.0))

    logbook["issues_count"] = _issues_count(logbook["issues"])
    logbook["observation_length"] = logbook["observation"].fillna("").astype(str).str.len()
    logbook["filled_fields"] = _filled_fields(logbook)

    quality = (
        logbook.groupby("source")
        .agg(
            entries=("entry_id", "count"),
            avg_observation_length=("observation_length", "mean"),
            avg_issues=("issues_count", "mean"),
            avg_filled_fields=("filled_fields", "mean"),
            pct_with_pta_milk=("pta_milk", lambda s: _percent(s.notna())),
            pct_with_reliability=("reliability", lambda s: _percent(s.notna())),
            pct_with_num_records=("num_records", lambda s: _percent(s.notna())),
        )
        .reset_index()
    )
    quality.to_csv(ASSETS_DIR / "llm_quality_by_source.csv", index=False)

    llm_models = logbook[logbook["source"].str.startswith("ollama:")].copy()
    if not llm_models.empty:
        llm_models["model"] = llm_models["source"].str.split(":", n=1).str[-1]
        model_counts = llm_models["model"].value_counts().reset_index()
        model_counts.columns = ["model", "entries"]
        model_counts.to_csv(ASSETS_DIR / "llm_model_counts.csv", index=False)

    metrics_df = pd.DataFrame(metrics, columns=["metric", "value"])
    metrics_df.to_csv(ASSETS_DIR / "analysis_metrics.csv", index=False)

    logbook.head(10).to_csv(ASSETS_DIR / "sample_entries.csv", index=False)
    raw.describe(include="all").to_csv(ASSETS_DIR / "raw_dataset_summary.csv")

    print("Analysis outputs written to report assets.")


if __name__ == "__main__":
    main()
