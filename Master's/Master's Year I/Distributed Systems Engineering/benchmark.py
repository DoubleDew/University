from cassandra.cluster import Cluster
from cassandra.policies import RoundRobinPolicy
import time, random, uuid

NODE_IPS = {
    'cassandra1': '172.18.0.2',
    'cassandra2': '172.18.0.3',
    'cassandra3': '172.18.0.4'
}

def get_sample_ids(session, n=100):
    rows = session.execute("SELECT id FROM users LIMIT %s", (n,))
    return [row.id for row in rows]

def run_read_benchmark(session, label, ids, n=1000):
    times = []
    for _ in range(n):
        uid = random.choice(ids)
        start = time.time()
        session.execute("SELECT * FROM users WHERE id = %s", (uid,))
        times.append((time.time() - start) * 1000)
    print(f"[READ - {label}] over {n} requests:")
    print(f"  Avg latency : {sum(times)/len(times):.2f} ms")
    print(f"  Min latency : {min(times):.2f} ms")
    print(f"  Max latency : {max(times):.2f} ms")

def run_write_benchmark(session, label, n=1000):
    names  = ['Andrei', 'Maria', 'Ion', 'Elena', 'Mihai', 'Ana', 'Dan', 'Ioana']
    cities = ['Bucharest', 'Cluj', 'Timisoara', 'Iasi', 'Constanta']
    times  = []
    for _ in range(n):
        start = time.time()
        session.execute(
            "INSERT INTO users (id, name, age, city) VALUES (%s, %s, %s, %s)",
            (uuid.uuid4(), random.choice(names), random.randint(18, 80), random.choice(cities))
        )
        times.append((time.time() - start) * 1000)
    print(f"[WRITE - {label}] over {n} requests:")
    print(f"  Avg latency : {sum(times)/len(times):.2f} ms")
    print(f"  Min latency : {min(times):.2f} ms")
    print(f"  Max latency : {max(times):.2f} ms")

for name, ip in NODE_IPS.items():
    cluster = Cluster([ip], port=9042, connect_timeout=30)
    session = cluster.connect('dse_test')
    ids = get_sample_ids(session)
    run_read_benchmark(session, f"Individual - {name}", ids)
    run_write_benchmark(session, f"Individual - {name}")
    cluster.shutdown()

all_ips = list(NODE_IPS.values())
cluster = Cluster(all_ips, load_balancing_policy=RoundRobinPolicy(), port=9042, connect_timeout=30)
session = cluster.connect('dse_test')
ids = get_sample_ids(session)
run_read_benchmark(session, "All 3 nodes (Round Robin)", ids)
run_write_benchmark(session, "All 3 nodes (Round Robin)")
cluster.shutdown()

print("\nDone!")
