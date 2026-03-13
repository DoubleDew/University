from __future__ import annotations

from pathlib import Path

import matplotlib.pyplot as plt
import pandas as pd

from src.config import ASSETS_DIR, LOGBOOK_CSV, LOGBOOK_PARQUET, RAW_DATA


def load_logbook() -> pd.DataFrame:
    if LOGBOOK_PARQUET.exists():
        return pd.read_parquet(LOGBOOK_PARQUET)
    if LOGBOOK_CSV.exists():
        return pd.read_csv(LOGBOOK_CSV)
    return pd.DataFrame()


def plot_trend(raw: pd.DataFrame) -> None:
    df = raw[["yob1", "W_HO_PTA_m_SB"]].dropna()
    df = df.sort_values("yob1")
    plt.figure(figsize=(8, 4))
    plt.plot(df["yob1"], df["W_HO_PTA_m_SB"], marker="o", linewidth=1)
    plt.title("PTA Milk Trend (Holstein, SB)")
    plt.xlabel("Year")
    plt.ylabel("PTA Milk")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "pta_milk_trend.png", dpi=150)
    plt.close()


def plot_reliability(raw: pd.DataFrame) -> None:
    df = raw["W_HO_REL_m_SB"].dropna()
    plt.figure(figsize=(6, 4))
    plt.hist(df, bins=12, color="#4C78A8", edgecolor="black")
    plt.title("Reliability Distribution (SB)")
    plt.xlabel("Reliability")
    plt.ylabel("Count")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "reliability_hist.png", dpi=150)
    plt.close()


def plot_num_records(raw: pd.DataFrame) -> None:
    df = raw[["yob1", "W_HO_NUM_PTA_SB"]].dropna()
    df = df.sort_values("yob1")
    plt.figure(figsize=(8, 4))
    plt.bar(df["yob1"], df["W_HO_NUM_PTA_SB"], color="#F58518")
    plt.title("Number of Records by Year (SB)")
    plt.xlabel("Year")
    plt.ylabel("Num Records")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "num_records_by_year.png", dpi=150)
    plt.close()


def plot_issues(logbook: pd.DataFrame) -> None:
    if logbook.empty:
        return
    df = logbook.copy()
    df["issue_count"] = df["issues"].fillna("").apply(lambda x: 0 if x == "" else len(x.split(";")))
    df["year"] = df["observed_at"].fillna("").astype(str).str.slice(0, 4)
    by_year = df.groupby("year", dropna=True)["issue_count"].sum().reset_index()
    by_year = by_year[by_year["year"].str.isnumeric()]
    if by_year.empty:
        return
    plt.figure(figsize=(8, 4))
    plt.plot(by_year["year"], by_year["issue_count"], marker="o", linewidth=1, color="#54A24B")
    plt.title("Extracted Issues by Year")
    plt.xlabel("Year")
    plt.ylabel("Issues")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "issues_by_year.png", dpi=150)
    plt.close()


def render_sample_table(logbook: pd.DataFrame) -> None:
    if logbook.empty:
        return
    sample = logbook.head(6)[
        ["observed_at", "pta_milk", "reliability", "num_records", "issues"]
    ].fillna("")

    fig, ax = plt.subplots(figsize=(8, 2))
    ax.axis("off")
    table = ax.table(
        cellText=sample.values,
        colLabels=sample.columns,
        cellLoc="center",
        loc="center",
    )
    table.auto_set_font_size(False)
    table.set_fontsize(8)
    table.scale(1, 1.2)
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "sample_table.png", dpi=150)
    plt.close()


def plot_llm_source_counts() -> None:
    path = ASSETS_DIR / "llm_source_counts.csv"
    if not path.exists():
        return
    df = pd.read_csv(path)
    if df.empty:
        return
    plt.figure(figsize=(6, 4))
    plt.bar(df["source"], df["entries"], color="#4C78A8")
    plt.title("Entries by Source")
    plt.xlabel("Source")
    plt.ylabel("Entries")
    plt.xticks(rotation=20, ha="right")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "llm_entries_by_source.png", dpi=150)
    plt.close()


def plot_llm_quality() -> None:
    path = ASSETS_DIR / "llm_quality_by_source.csv"
    if not path.exists():
        return
    df = pd.read_csv(path)
    if df.empty:
        return

    plt.figure(figsize=(6, 4))
    plt.bar(df["source"], df["avg_issues"], color="#F58518")
    plt.title("Avg Issues by Source")
    plt.xlabel("Source")
    plt.ylabel("Avg Issues")
    plt.xticks(rotation=20, ha="right")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "llm_avg_issues_by_source.png", dpi=150)
    plt.close()

    plt.figure(figsize=(6, 4))
    plt.bar(df["source"], df["avg_observation_length"], color="#54A24B")
    plt.title("Avg Observation Length by Source")
    plt.xlabel("Source")
    plt.ylabel("Characters")
    plt.xticks(rotation=20, ha="right")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "llm_avg_observation_length.png", dpi=150)
    plt.close()


def plot_llm_models() -> None:
    path = ASSETS_DIR / "llm_model_counts.csv"
    if not path.exists():
        return
    df = pd.read_csv(path)
    if df.empty:
        return
    plt.figure(figsize=(6, 4))
    plt.bar(df["model"], df["entries"], color="#B279A2")
    plt.title("LLM Entries by Model")
    plt.xlabel("Model")
    plt.ylabel("Entries")
    plt.xticks(rotation=20, ha="right")
    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "llm_entries_by_model.png", dpi=150)
    plt.close()


def draw_pipeline_diagram() -> None:
    fig, ax = plt.subplots(figsize=(8, 3))
    ax.axis("off")

    boxes = [
        ("Audio or Text", 0.05, 0.5),
        ("Speech-to-Text", 0.30, 0.5),
        ("LLM Structuring", 0.55, 0.5),
        ("Logbook (Parquet)", 0.80, 0.5),
    ]

    for label, x, y in boxes:
        ax.add_patch(plt.Rectangle((x, y), 0.18, 0.25, fill=False, linewidth=1.5))
        ax.text(x + 0.09, y + 0.125, label, ha="center", va="center", fontsize=9)

    for i in range(len(boxes) - 1):
        x1 = boxes[i][1] + 0.18
        x2 = boxes[i + 1][1]
        y = boxes[i][2] + 0.125
        ax.annotate(
            "",
            xy=(x2, y),
            xytext=(x1, y),
            arrowprops=dict(arrowstyle="->", linewidth=1.5),
        )

    plt.tight_layout()
    plt.savefig(ASSETS_DIR / "pipeline_overview.png", dpi=150)
    plt.close()


def main() -> None:
    ASSETS_DIR.mkdir(parents=True, exist_ok=True)
    raw = pd.read_csv(RAW_DATA, na_values=["#N/A", "NA", "N/A"])
    logbook = load_logbook()

    plot_trend(raw)
    plot_reliability(raw)
    plot_num_records(raw)
    plot_issues(logbook)
    render_sample_table(logbook)
    draw_pipeline_diagram()
    plot_llm_source_counts()
    plot_llm_quality()
    plot_llm_models()
    print(f"Assets written to {ASSETS_DIR}")


if __name__ == "__main__":
    main()
