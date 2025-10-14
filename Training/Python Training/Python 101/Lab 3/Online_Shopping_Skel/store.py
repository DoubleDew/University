import cart

class Store:
    def __init__(self, stock):
        self.stock = stock
        self.customer_carts = dict() #! de explicat in enunt: dict(customer_id, cart)

    def login(self, customer_id):
        self.customer_carts[customer_id] = cart.Cart()

    def add_to_cart(self, customer_id, product_name):
        if customer_id not in self.customer_carts:
            print("The customer is not logged in!")
            return   
        
        for product in self.stock.list_stock:
            if product.name == product_name:
                self.customer_carts[customer_id].add(product)
                self.stock.remove(product)
    
    def remove_from_cart(self, customer_id, product_name):
        if customer_id not in self.customer_carts:
            print("The customer is not logged in!")
            return 
        
        cart = self.customer_carts[customer_id]
        
        for product in cart.list_cart:
            if product.name == product_name:
                cart.remove(product)
                self.stock.list_stock.append(product)

                
    def view_cart(self, customer_id):
        return [(product.name, product.price) for product in self.customer_carts[customer_id].list_cart]
    
    def checkout(self, customer_id):
        return self.customer_carts[customer_id].cart_checkout()

