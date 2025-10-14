import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    ArrayList<Medicine> medStock = new ArrayList<>();
    
    Pharmacy(){
        System.out.println("Pharmacy is open!\n");
    }

    public void addMedicine(Medicine med){
        this.medStock.add(med);
        System.out.println("Medicine added!");
    }

    public void checkStock(){
        for(Medicine med : this.medStock){
            if(med.getStock() == 0)
                this.medStock.remove(med);
        }
    }

    public Map<String, Integer> toMap(){
        Map<String, Integer> output = new HashMap<>();

        //check all meds from the pharmacy
        for(Medicine med : this.medStock){
            //parse all ingredients of the medicine med
            for(String ingredient : med.getIngredients()){
                if(output.containsKey(ingredient)){
                    //when the ingredient already exists inside the HashMap
                    int temp = output.get(ingredient);
                    temp++;
                    output.put(ingredient, temp);
                }
                else{
                    output.put(ingredient, 1);
                }
            }
        }
        return output;
    }
}
