import java.util.*;

public class Main {
    public static void main(String[] args){
        Pharmacy p = new Pharmacy();
        
        Set<String> ingredients1 = new HashSet();
        Collections.addAll(ingredients1, "ingredient 1", "ingredient 2", "ingredient 2");
        p.addMedicine(new Medicine("medicine 1", "indications 1", "contraindication 1", ingredients1, 10, 1));

        Set<String> ingredients2 = new HashSet();
        Collections.addAll(ingredients2, "ingredient 2", "ingredient 3", "ingredient 4");
        p.addMedicine(new Medicine("medicine 2", "indications 2", "contraindication 2", ingredients2, 12.5, 0));

        Set<String> ingredients3 = new HashSet();
        Collections.addAll(ingredients3, "ingredient 1", "ingredient 2", "ingredient 4");
        p.addMedicine(new Medicine("medicine 3", "indications 3", "contraindication 3", ingredients3, 15.5, 7));

        Set<String> ingredients4 = new HashSet();
        Collections.addAll(ingredients4, "ingredient 1", "ingredient 3", "ingredient 2");
        p.addMedicine(new Medicine("medicine 4", "indications 4", "contraindication 4", ingredients4, 20, 2));

        System.out.println();

        for(Medicine med : p.medStock){
            System.out.println(med.getName() + " - " + med.getPrice() + " - " + med.getStock());
            System.out.println(med.toString());
        }

        System.out.println();

        System.out.println(p.toMap().toString());

        System.out.println();

        p.checkStock();
        for(Medicine med : p.medStock){
            System.out.println(med.toString());        
        }
    }    
}
