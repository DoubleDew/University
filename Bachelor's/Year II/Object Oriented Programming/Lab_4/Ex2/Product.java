package Ex2;

public class Product 
{
    private String productName;
    private String description;
    private String ingredients;
    private String expiryDate;

    public Product(String pname, String desc, String ingred, String eDate)
    {
        this.productName = pname;
        this.description = desc;
        this.ingredients = ingred;
        this.expiryDate = eDate;
    }

    @Override
    public String toString()
    {
        return "Product Name: " + this.productName + 
               " Description: " + this.description + 
               " Ingredients: " + this.ingredients + 
               " Expiry Date: " + this.expiryDate;
    }

    public boolean equals(Product prod)
    {
        if(!(prod instanceof Product))
            return false;
        if(prod == this)
            return true;
        return this.productName.equals(((Product) prod).productName); 
    }

    public int hashCode()
    {
        return (int) (productName.length() + Math.random()*10);
    }
}