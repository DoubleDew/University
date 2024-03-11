public class Book 
{
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    public Book(String name, Author author, double price)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = 0;
    }

    public Book(String name, Author author, double price, int qtyInStock)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }
    public String getName()
    {
        return name;
    }
    public Author getAuthor()
    {
        return author;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQtyInStock()
    {
        return qtyInStock;
    }
    public void setQtyInStock(int stock)
    {
        this.qtyInStock = stock;
    }
    public String toString()
    {
        Author a = getAuthor();
        String b = a.toString();
        return b;
    }
    public String getAuthorName()
    {
        //Author a = getAuthor();
        return author.getName();
    }
    public String getAuthorEmail()
    {
        //Author a = getAuthor();
        return author.getEmail();
    }
    public char getAuthorGender()
    {
        //Author a = getAuthor();
        return author.getGender();
    }
}