class Stock:
    def __init__(self, list_stock):
        self.list_stock = []
        for product in list_stock:
            self.list_stock.append(product)

    def add(self, new_product):
        self.list_stock.append(new_product)
           
    def remove(self, product_name):
        for product in self.list_stock:
            if product_name == product.name:
                self.list_stock.remove(product)
                break

    def view(self):
        return self.list_stock