package Ex2;
import java.util.*;

public class Test 
{
    public static void main(String[] args)
    {
        HashSet<Product> products = new HashSet<Product>();

        Product p1 = new Product("Lapte", "Description 1", "Ingredients 1", "Expiry Date 1");
        products.add(p1);

        Product p2 = new Product("Paine", "Description 2", "Ingredients 2", "Expiry Date 2");
        products.add(p2);

        Product p3 = new Product("Carne", "Description 3", "Ingredients 3", "Expiry Date 3");
        products.add(p3);

        Product p4 = new Product("Fructe", "Description 4", "Ingredients 4", "Expiry Date 4");
        products.add(p4);

        Product p5 = new Product("Lapte", "Description 1", "Ingredients 1", "Expiry Date 1");
        products.add(p5);
    }    
}
