package pp.lab7;

public class Main {
    public static void main(String[] args) {
        TimePrinterThread t1 = new TimePrinterThread();
        TimePrinterThread t2 = new TimePrinterThread();
        TimePrinterThread t3 = new TimePrinterThread();

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Threads started!");
    }
}