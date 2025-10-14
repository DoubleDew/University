package Point;

// There is a Point3D class in the course but it is basically the same as this one 
// but with extra z coordinate, so I didn't include it here. If you want to do it, 
// don't forget to update the PointIF interface as well. 

public class Point implements PointIF {
    private int x, y;
    private Plane plane;
    
    public void getPlane(){
        System.out.println(plane.getPlane());
    }

    // constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void readX() {
        System.out.println("The x coordinate is " + this.x);
    }

    @Override
    public int changeX(int newX) {
        this.x = newX;
        return this.x;
    }

    @Override
    public void readY() {
        System.out.println("The y coordinate is " + this.y + "\n");
    }

    @Override
    public int changeY(int newY) {
        this.y = newY;
        return this.y;
    }

    @Override
    public String getPointInfo() {
        return "The new coordinates are: (" + this.x + " , " + this.y + ")" + "\n";
    }

    // The reason for this class Plane is to show the behavior of a nested class and how to deal with it.
    // PS: Looks quite bothersome to me, ngl, but it's a good example.
    static class Plane{
        private String p = "x0yz";

        public String getPlane(){
            return p;
        }
    }

    public static void main(String args[]) {
        // If you don't add the constructor, it's fine, just be careful to not add the params in the next line.
        Point p = new Point(3, 4);

        p.readX();
        p.readY();

        p.plane = new Plane();

        System.out.println("The new y coordinate is: " + p.changeX(5));
        System.out.println("The new y coordinate is: " + p.changeY(6));

        System.out.print(p.getPointInfo());

        System.out.println(Point.Plane.class.getName());
        p.getPlane();
    }
}
