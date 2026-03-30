package pp.lab7.ex3;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(5);
        Cook c1 = new Cook("Alex", kitchen);  c1.start();
        Cook c2 = new Cook("Andrei", kitchen); c2.start();
        Cook c3 = new Cook("Miruna", kitchen);    c3.start();
        
        Waiter w1 = new Waiter("Raul", kitchen);  w1.start();
        Waiter w2 = new Waiter("Mihail", kitchen);   w2.start();
        Waiter w3 = new Waiter("George", kitchen);    w3.start();
        Waiter w4 = new Waiter("Mihaela", kitchen);   w4.start();         
    }
}