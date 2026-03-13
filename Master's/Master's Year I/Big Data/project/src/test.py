import pandas as pd
df = pd.read_parquet('data/processed/logbook.parquet')
print(df['source'].unique())