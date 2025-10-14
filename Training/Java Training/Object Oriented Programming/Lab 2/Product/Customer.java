import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Customer {
    private String username;
    private int maxProducts = 10;
    private List<SoftwareProduct> products = new ArrayList<>();

    public Customer(String username){
        this.username = username;
    }

    public void addProduct(SoftwareProduct sp){
        if(products.size() < maxProducts){
            products.add(sp);
            System.out.println("Product added! \n");
        }
        else{
            System.out.println("Cannot add more products! \n");
        }
    }

    public void removeProduct(String name){
        for(SoftwareProduct sp : products){
            if(sp.getName().equalsIgnoreCase(name)){
                products.remove(sp);
                System.out.println("Product removed! \n");
                return;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        Computer computer = new Computer(8, "i7");
        Customer customer = new Customer("John");
        GameProduct gp = new GameProduct("Elden Ring", "Windows");
        GameProduct gp2 = new GameProduct("Marvel's Spider-Man 2", "PlayStation");
        OfficeProduct op = new OfficeProduct("Office", "Windows");
        OfficeProduct op2 = new OfficeProduct("Office", "Windows");

        try{
            gp.store("input2.txt");
            gp.read("input2.txt");
            System.out.println(gp.compareTo(gp2));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        computer.setRAM(800);
        computer.setCPU("i7");
        
        customer.addProduct(gp);
        customer.addProduct(op);
        customer.addProduct(gp2);

        for(SoftwareProduct sp : customer.products){
            System.out.println(sp.getName() + ", " + sp.getPlatform() + "\n");
        }

        for(SoftwareProduct sp : customer.products){
            sp.checkCompatibility();
        }

        customer.removeProduct("Marvel's Spider-Man 2");

        for(SoftwareProduct sp : customer.products){
            System.out.println(sp.getName() + ", " + sp.getPlatform());
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
