public class Video 
{
    private String title;
    private int length; 
    private boolean available;
    public Video(String t)
    {
        this.title=t;
        this.length=90;
        this.available=true;
    }
    public Video(String t, int l)
    {
        this.title=t;
        this.length=l;
        this.available=true;
    }
    public void show()
    {
        System.out.println( "The video " + this.title + " has " + this.length + " minutes and it is " + this.available + " that it is in the store" );
    }    
}