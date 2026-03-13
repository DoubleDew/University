# Automated Dairy Logbook Entry from Speech (LLM)

This project converts spoken dairy observations into structured, searchable logbook entries. It uses a local speech-to-text model (optional), then a local LLM (optional) or a rule-based parser to produce JSON entries stored in Parquet.

## Quick start

1) Create a virtual environment and install deps:

```bash
python -m venv .venv
.venv\\Scripts\\activate
pip install -r requirements.txt
```

2) Generate synthetic transcripts from the open dataset:

```bash
python -m scripts.generate_synthetic_transcripts
```

3) Build the logbook:

```bash
python -m src.main --transcripts data/synthetic/transcripts.txt --mode rule_based
```

4) Generate analysis outputs and report assets:

```bash
python -m src.analysis
python -m scripts.generate_report_assets
```

## Local LLM option

If you have Ollama running locally:

```bash
python -m src.main --transcripts data/synthetic/transcripts.txt --mode ollama --model llama3
```

## Local speech-to-text option

Provide an audio file with `--audio` after installing `faster-whisper` or `openai-whisper`.

## Dataset

Open dataset: "Changes in genetic selection differentials and generation intervals in US Holstein dairy cattle as a result of genomic selection" (Figshare via data.gov).
The raw file is stored at `data/raw/holstein_genomic_selection.csv`.

###### Notes added by Danut #######

# Running tips and commands for speech-to-text functionality 
.venv\Scripts\activate.bat

# Optional, but nice to have; start clean to see the results in a better way
# by renaming the old logbook to logbook_old and starting a new one as logbook
if exist data\processed\logbook.parquet rename data\processed\logbook.parquet logbook_old.parquet
if exist data\processed\logbook.csv rename data\processed\logbook.csv logbook_old.csv

# Run the audio file 
#   Rule-based
python -s -m src.main --audio "my_note.wav" --mode rule_based

#   Run with LLM
python -m src.main --audio "my_note.wav" --mode ollama --model llama3

# Converting parquet to csv to see the text 
python -c "import pandas as pd; df=pd.read_parquet('data/processed/logbook.parquet'); df.to_csv('data/processed/logbook.csv', index=False); print(df[['cow_id','issues','observation']].to_string(index=False))"