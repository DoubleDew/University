package pp.lab7.ex3;

public class Pizza{
    private int id;
    private static int count = 1;
    private Integer nrOfIngredients;

    public Pizza(Integer vNrOfIngredients){
        this.id = count++;
        this.nrOfIngredients = vNrOfIngredients;
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getNrOfIngredients(){
        return this.nrOfIngredients;
    }
}