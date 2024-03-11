public class TestForm 
{
    public static void main(String args[])
    {

        Form[] form = new Form[3];
        form[0] = new Point(0, 0);
        form[1] = new Circle(5, 0, 0);
        form[2] = new Cylinder(10, 7, 0 ,0);

        for(int i = 0; i < 3; i++)
        {
            System.out.println(form[i].toString());
            System.out.println("The area is: " + form[i].computeArea());
            System.out.println("The volume is: " + form[i].computeVolume());
            System.out.println();
        }
    }
}