import pandas as pd
import firebase_admin
from firebase_admin import credentials, firestore

def mapStringToList(string):
    lst = string.split(",")
    newLst = []
    for elem in lst:
        newLst.append(parsedElem)
    return newLst

def mapNumberToBoolean(number):
    return True if number == 1 else False

cred = credentials.Certificate("pk.json")
firebase_admin.initialize_app(cred)
py
db = firestore.client()
doc_ref = db.collection(u'products')

df = pd.read_csv("Test.csv")
tmp = df.to_dict(orient="records")

for row in tmp:
    for key, value in row.items():
        if key == "Color":
            if value != 0:
                row[key] = mapStringToList(value)
        if key == "inStock":
            row[key] = mapNumberToBoolean(value)

print(tmp)
list(map(lambda x: doc_ref.add(x), tmp))

# Export Data
docs = doc_ref.stream()
for doc in docs:
    print(f"{doc.id} => {doc.to_dict()}")