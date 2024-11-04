class Product:
    def __init__(self, name, price):
        self.name = name
        self.price = price

    def __add__(self, other):        
        return int(self.price) + int(other.price)
    