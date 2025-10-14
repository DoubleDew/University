package Lab_1;

public class Food extends Vending_Machine
{
    private int stock;
    
    public Food(int id, int stock)
    {
        super(id, stock);
        this.stock = stock;
    }

    public int getStock()
    {
        return name;
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
            System.out.println("Operation successfull");
        }
        else 
            System.out.println("Operation unsuccessfull");
    }

}
