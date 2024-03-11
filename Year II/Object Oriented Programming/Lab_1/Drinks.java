package Lab_1;

public class Drinks extends Vending_Machine
{
    private int stock;
    
    public Drinks(int id, int stock)
    {
        super(id, stock);
        this.stock = stock;
    }

    public int getStock()
    {
        return stock;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }

    @Override
    public void sell(int sold_items)
    {
        if(this.getStock() >= sold_items)
        {
            this.setStock(this.stock - sold_items);
            System.out.println("Operation successful");
        }
        else 
            System.out.println("Operation unsuccessful");
    }

}
