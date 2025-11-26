package pp.lab7;

import java.time.LocalTime;

public class TimePrinterThread extends Thread{
    @Override
    public void run(){
        while (true) {
            System.out.println("[" + getName() + " ] Current time: " + LocalTime.now());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
                return;
            }
        }
    }
}