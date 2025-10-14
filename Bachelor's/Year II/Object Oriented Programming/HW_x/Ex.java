import java.util.concurrent.*;
import java.util.*;

class OnlineShop {
    // shared data structure for stock
    private static Map<String, Integer> stock = new HashMap<>();
    // waiting queue for client requests
    private static BlockingQueue<Request> requests = new ArrayBlockingQueue<>(10);

    static class Request {
        private final String productName;
        private final int quantity;

        Request(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    static class Client extends Thread {
        private final String productName;
        private final int quantity;

        Client(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }

        @Override
        public void run() {
            Request request = new Request(productName, quantity);
            try {
                // send request to waiting queue
                requests.put(request);
                System.out.println("Client sent a request for " + quantity + " " + productName + "(s)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Employee extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // take a request from the queue
                    Request request = requests.take();
                    String productName = request.getProductName();
                    int quantity = request.getQuantity();
                    int stockQuantity = stock.getOrDefault(productName, 0);

                    // check if stock is sufficient
                    if (stockQuantity >= quantity) {
                        stock.put(productName, stockQuantity - quantity);
                        System.out.println("Employee fulfilled request for " + quantity + " " + productName + "(s)");
                    } else {
                        System.out.println("Request for " + quantity + " " + productName + "(s) cannot be fulfilled");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // initialize stock
        stock.put("product1", 100);
        stock.put("product2", 200);

        // start client threads
        new Client("product1", 10).start();
        new Client("product2", 25).start();
        new Client("product1", 50).start();

        // start employee threads
        new Employee().start();
        new Employee().start();
    }
}