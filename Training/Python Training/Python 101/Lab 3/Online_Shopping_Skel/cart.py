class Cart:
    def __init__(self):
        self.list_cart = []

    def add(self, new_product):
        self.list_cart.append(new_product)

    def remove(self, product_name):
        for product in self.list_cart:
            if product.name == product_name:
                self.list_cart.remove(product)
                break

    def view(self):
        return self.list_cart

    def cart_checkout(self):            
        total = sum(product.price for product in self.list_cart)
        
        self.list_cart.clear()
        
        return total