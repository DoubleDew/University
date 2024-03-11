abstract class Card
{
    protected String recipient;

    public abstract void greeting();
}

class Holiday extends Card
{
    //String n;

    public Holiday(String x)
    {
        recipient = x;
    }

    @Override
    public void greeting()
    {
        System.out.println("Dear " + recipient + ",");
        System.out.println("Season's Greetings!");
    }
}

class Birthday extends Card
{
    //String n;
    private int age;

    public Birthday(String x, int i)
    {
        recipient = x;
        this.age = i;
    }

    @Override
    public void greeting()
    {
        System.out.println("Dear " + recipient + ",");
        System.out.println("Happy " + age + "th Birthday!");
    }
}