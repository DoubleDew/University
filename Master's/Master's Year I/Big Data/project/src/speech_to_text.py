from __future__ import annotations

from pathlib import Path
from typing import Optional


class SpeechToTextError(RuntimeError):
    pass


def transcribe_audio(audio_path: Path, model: str = "small") -> str:
    """
    Transcribe local audio using an offline model if available.
    Supports faster-whisper or openai-whisper when installed.
    """
    audio_path = Path(audio_path)
    if not audio_path.exists():
        raise SpeechToTextError(f"Audio file not found: {audio_path}")

    try:
        from faster_whisper import WhisperModel
    except Exception:
        WhisperModel = None

    if WhisperModel is not None:
        stt_model = WhisperModel(model, device="cpu", compute_type="int8")
        segments, _info = stt_model.transcribe(str(audio_path))
        return " ".join(seg.text.strip() for seg in segments).strip()

    try:
        import whisper  # type: ignore
    except Exception as exc:
        raise SpeechToTextError(
            "No local speech-to-text backend available. "
            "Install faster-whisper or openai-whisper."
        ) from exc

    stt_model = whisper.load_model(model)
    result = stt_model.transcribe(str(audio_path))
    return (result.get("text") or "").strip()


def get_transcript(text: Optional[str] = None, audio_path: Optional[Path] = None) -> str:
    if text:
        return text.strip()
    if audio_path:
        return transcribe_audio(audio_path)
    raise SpeechToTextError("Provide either text or audio_path for transcription.")
