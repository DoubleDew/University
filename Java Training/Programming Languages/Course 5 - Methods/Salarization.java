public class Salarization {
    // as the method does not have static (see main)
    // if you have static (see main)
    public double computeSal(int numberOfHours, double hourlyPay) {
        double sal;
        if (numberOfHours < 0 || hourlyPay < 0) {
            System.out.println("Negative numbers for parameters!");
            return 0;
        } else if (numberOfHours <= 40) {
            sal = hourlyPay * numberOfHours;
        } else
            sal = 40 * hourlyPay + 1.5 * numberOfHours * (numberOfHours - 40);
        return sal;
    }

    public static void main(String[] args) {
        // you need to create a variable of the type of the class and then call variable.method
        // you can directly call the method like second print line or use the class_name.method
        Salarization s = new Salarization();
        System.out.println("Total salary (40h): " + s.computeSal(40, 20.9));
        // System.out.println("Total salary: " + computeSal(44, 20.9));

        System.out.println(s.computeSal(32, 21));
    }
}
