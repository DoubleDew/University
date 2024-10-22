import java.util.HashSet;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<Product>();

        Product p1 = new Product("A", "Nice and sweet", "Ingredient 1, Ingredient 2", new GregorianCalendar(2022, 12, 31));
        Product p2 = new Product("A", "Nice and sweet", "Ingredient 1, Ingredient 2", new GregorianCalendar(2022, 12, 31));
        Product p3 = new Product("B", "Nice and sour", "Ingredient 3, Ingredient 4", new GregorianCalendar(2022, 1, 21));
        Product p4 = new Product("C", "Nice and spicy", "Ingredient 5, Ingredient 6", new GregorianCalendar(2022, 4, 15));
        Product p5 = new Product("D", "Sweet and spicy", "Ingredient 7, Ingredient 8", new GregorianCalendar(2022, 8, 30));
        Product p6 = new Product("E", "Super spicy", "Ingredient 9, Ingredient 10", new GregorianCalendar(2022, 6, 3));

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

        System.out.println("We have " + products.size() + " products in the set");

        System.out.println(p1.equals(p2));
        System.out.println(p3.equals(p4));

        System.out.println(p1.hashCode());
    }
}
