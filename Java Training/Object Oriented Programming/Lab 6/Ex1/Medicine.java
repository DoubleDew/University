import java.util.*;

public class Medicine implements Comparable<Medicine>{
    private String name;
    private String indications;
    private String contraindications;
    Set<String> ingredients = new HashSet(); // no duplicates -> HashSet
    private double price;
    private int stock;

    public Medicine(String name, String indications, String contraindications, double price, int stock) {
        this.name = name;
        this.indications = indications;
        this.contraindications = contraindications;
        this.price = price;
        this.stock = stock;
    }

    

    public Medicine(String name, String indications, String contraindications, Set<String> ingredients, double price, int stock) {
        this.name = name;
        this.indications = indications;
        this.contraindications = contraindications;
        this.ingredients = ingredients;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getContraindications() {
        return contraindications;
    }


    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Medicine { " + 
            "name = " + name + 
            ", indications = " + indications + 
            ", contraindications = " + contraindications +
            ", ingredients = " + ingredients + 
            ", price = " + price + 
            ", stock = " + stock + 
            "}";
    }

    @Override
    public int compareTo(Medicine medicine) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this.getPrice() < medicine.getPrice())
            return BEFORE;
        if(this.getPrice() > medicine.getPrice())
            return AFTER;
        return EQUAL;
    }

    public int compareName(Medicine medicine){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        // if(this.getName().equalsIgnoreCase(medicine.getName()))
        //     return BEFORE;
        // if(this.getName().equalsIgnoreCase(medicine.getName()))
        //     return AFTER;
        // return EQUAL;

        if(Integer.parseInt(this.getName()) < Integer.parseInt(medicine.getName()))
            return BEFORE;
        if(Integer.parseInt(this.getName()) > Integer.parseInt(medicine.getName()))
            return AFTER;
        return EQUAL;
    }
}

