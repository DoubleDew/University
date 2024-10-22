import java.util.GregorianCalendar;

public class Product{
    private String name;
    private String description;
    private String ingredients;
    private GregorianCalendar expiryDate;

    public Product(String name, String description, String ingredients, GregorianCalendar expiryDate){
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.expiryDate = expiryDate;
    }

    public boolean equals(Product prod){
        if(!(prod instanceof Product))
            return false;
        if(prod == this)
            return true;
        return this.name.equals(((Product) prod).name);
    }

    public int hashCode(){
        return (int) (name.length() + Math.random() * 10);
    }
}