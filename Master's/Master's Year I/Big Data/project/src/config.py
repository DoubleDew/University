from pathlib import Path

PROJECT_ROOT = Path(__file__).resolve().parents[1]
DATA_DIR = PROJECT_ROOT / "data"
RAW_DATA = DATA_DIR / "raw" / "holstein_genomic_selection.csv"
PROCESSED_DIR = DATA_DIR / "processed"
SYNTHETIC_DIR = DATA_DIR / "synthetic"

LOGBOOK_PARQUET = PROCESSED_DIR / "logbook.parquet"
LOGBOOK_CSV = PROCESSED_DIR / "logbook.csv"

REPORT_DIR = PROJECT_ROOT / "report"
ASSETS_DIR = REPORT_DIR / "report_assets"
