commands for presentation:
whisper my_note.wav --model base.en --language English (shows that the speech to text works displaying the text in console)

.venv\Scripts\activate.bat (activate the venv)

docker compose up -d (starts docker)

docker ps (checks if it started right)

python -m src.main --audio my_note.wav --mode ollama (write entries to logbook.parquet)

python -c "import pandas as pd; df=pd.read_parquet('data/processed/logbook.parquet'); df.to_csv('data/processed/logbook.csv', index=False); print('CSV updated from Parquet:', len(df))" (exports parquet to csv)

docker exec -it namenode hdfs dfs -mkdir -p /project/logbook
docker exec -it namenode hdfs dfs -ls /
(both lines interact with Hadoop and list the /project folder, i think)

docker cp data\processed\logbook.parquet namenode:/tmp/logbook.parquet (copy it into NameNode container)

docker exec -it namenode hdfs dfs -put -f /tmp/logbook.parquet /project/logbook/ (upload it to HDFS / updates web UI)

docker exec -it namenode hdfs dfs -ls -h /project/logbook (verify)

docker compose down (shut down docker)

