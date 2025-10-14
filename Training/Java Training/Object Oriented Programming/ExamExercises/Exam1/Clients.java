import java.util.*;

public class Clients {
    private String name, email;
    private List<Event> purchase = new ArrayList<>();

    public Clients(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void addEvent(Event event) throws Exception{
       for(Event e : purchase){
            if(event.overlaps(e))
                throw new Exception("Event overlaps with another event!");
       }

       this.purchase.add(event);
       System.out.println("Added event: " + event.toString());
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Event> getPurchase(){
        return purchase;
    }

    public void setPurchase(List<Event> purchase){
        this.purchase = purchase;
    }

    public void sortByType(){
        Collections.sort(purchase, new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2){
                return e1.getType().compareTo(e2.getType());
            }
        });
        System.out.println();
    }

    public void sortByPrice(){
        Collections.sort(purchase, new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2){
                int temp1 = e1.getPrice();
                int temp2 = e2.getPrice();

                return Integer.compare(temp1, temp2);
            }
        });
        System.out.println();
    }  
}
