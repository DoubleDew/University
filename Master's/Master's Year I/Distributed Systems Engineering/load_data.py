from cassandra.cluster import Cluster
from cassandra.policies import RoundRobinPolicy
import uuid, random, time

cluster = Cluster(
    ['cassandra1'],
    load_balancing_policy=RoundRobinPolicy(),
    port=9042
)
session = cluster.connect()

session.execute("""
    CREATE KEYSPACE IF NOT EXISTS dse_test
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3}
""")
session.set_keyspace('dse_test')

session.execute("""
    CREATE TABLE IF NOT EXISTS users (
        id UUID PRIMARY KEY,
        name text,
        age int,
        city text
    )
""")

cities = ['Bucharest', 'Cluj', 'Timisoara', 'Iasi', 'Constanta']
names  = ['Andrei', 'Maria', 'Ion', 'Elena', 'Mihai', 'Ana', 'Dan', 'Ioana']

print("Inserting 10,000 records...")
start = time.time()
for i in range(10000):
    session.execute(
        "INSERT INTO users (id, name, age, city) VALUES (%s, %s, %s, %s)",
        (uuid.uuid4(), random.choice(names), random.randint(18, 80), random.choice(cities))
    )
elapsed = time.time() - start
print(f"Done! Inserted 10,000 records in {elapsed:.2f}s")

cluster.shutdown()
