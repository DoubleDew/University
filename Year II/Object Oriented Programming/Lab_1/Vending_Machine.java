package Lab_1;

public abstract class Vending_Machine 
{
    private int id;
    private int stock;
    
    public Vending_Machine(int id, int stock)
    {
        this.id = id;
        this.stock = stock;
    }

    public abstract void sell(int stock);

    public int getID() 
    { 
        return id; 
    }
    public void setID(int id) 
    { 
        this.id = id; 
    }

    public String getStock() 
    { 
        return stock; 
    }
    public void setStock(int stock) 
    { 
        this.stock = stock; 
    }
}
