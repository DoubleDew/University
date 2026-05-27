# Distributed Systems Engineering — Apache Cassandra Cluster
**Deaconu Mircea-Dan | Master's Year I | May 2026**

Three-node Cassandra cluster in Docker. Includes dataset loading and read/write benchmarking.

## Files
- `load_data.py` — inserts 10,000 records into the cluster
- `benchmark.py` — benchmarks read/write latency per node and with Round Robin

## How to Run
```bash
docker start cassandra1 cassandra2 cassandra3
docker exec -it cassandra1 python3 /load_data.py
docker exec -it cassandra1 python3 /benchmark.py
```
