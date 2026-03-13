from __future__ import annotations

import argparse
import sys
from pathlib import Path

if __package__ in (None, ""):
    # Allow running as a script: python src/main.py
    sys.path.append(str(Path(__file__).resolve().parents[1]))
    from src.llm_structurer import structure_transcript
    from src.logbook import append_entries
    from src.speech_to_text import get_transcript
else:
    from .llm_structurer import structure_transcript
    from .logbook import append_entries
    from .speech_to_text import get_transcript


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="STT + LLM logbook pipeline")
    parser.add_argument("--transcripts", type=Path, help="Path to text file of transcripts")
    parser.add_argument("--text", type=str, help="Single transcript text")
    parser.add_argument("--audio", type=Path, help="Path to audio file for transcription")
    parser.add_argument("--mode", type=str, default="rule_based", choices=["rule_based", "ollama"])
    parser.add_argument("--model", type=str, default="llama3")
    parser.add_argument("--limit", type=int, default=None)
    return parser.parse_args()


def main() -> None:
    args = parse_args()

    transcripts = []
    if args.transcripts:
        lines = args.transcripts.read_text(encoding="utf-8").splitlines()
        transcripts.extend([line for line in lines if line.strip()])
    elif args.text or args.audio:
        transcripts.append(get_transcript(text=args.text, audio_path=args.audio))
    else:
        raise SystemExit("Provide --transcripts or --text/--audio.")

    if args.limit:
        transcripts = transcripts[: args.limit]

    entries = [structure_transcript(t, mode=args.mode, model=args.model) for t in transcripts]
    out_path = append_entries(entries)
    print(f"Wrote {len(entries)} entries to {out_path}")


if __name__ == "__main__":
    main()
