package pp.lab7.ex1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting 3 TimeThread instances (extends Thread)...");
        for (int i = 1; i <= 3; i++) {
            new TimePrinterThread("TimePrinterThread-" + i).start();
        }

        System.out.println("Starting 3 TimeRunnable instances (implements Runnable)...");
        for (int i = 1; i <= 3; i++) {
            new Thread(new TimeRunnable("TimeRunnable-" + i)).start();
        }
    }
}