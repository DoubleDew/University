import java.util.*;

public class Main {

    public static Map<Event.Type, List<Clients>> getClientsByEventMap(List<Clients> clients){
        Map<Event.Type, List<Clients>> eventTypeMap = new HashMap<>();

        for(Clients cl : clients){
            for(Event ev : cl.getPurchase()){
                eventTypeMap.computeIfAbsent(ev.getType(), k -> new ArrayList<>()).add(cl);
            }
        }

        return eventTypeMap;
    }

    public static void main(String[] args) throws Exception{
        Event e1 = new Event(100, new GregorianCalendar(2024, 1, 1), new GregorianCalendar(2024, 1, 6), "Location 1", Event.Type.RETREAT);
        Event e2 = new Event(100, new GregorianCalendar(2024, 4, 15), new GregorianCalendar(2024, 4, 21), "Location 2", Event.Type.CONFERENCE);
        Event e3 = new Event(100, new GregorianCalendar(2024, 6, 11), new GregorianCalendar(2024, 6, 12), "Location 3", Event.Type.CONFERENCE);

        Clients c1 = new Clients("Client 1", "client1@email.com");
        Clients c2 = new Clients("Client 2", "client2@email.com");

        try{
            c1.addEvent(e1);
            c1.addEvent(e2);

            c2.addEvent(e3);
            
            c1.sortByType(); // or c1.sortByPrice();
            c2.sortByType(); // or c2.sortByPrice();

            System.out.println(c1.getName() + "'s events sorted by type: " + c1.getPurchase().toString() + "\n");
            System.out.println(c2.getName() + "'s events sorted by type: " + c2.getPurchase().toString() + "\n");

            ArrayList<Clients> clientList = new ArrayList<>();
            clientList.add(c1);
            clientList.add(c2);

            Map<Event.Type, List<Clients>> eventTypeMap = new HashMap<>();

            for(Map.Entry<Event.Type, List<Clients>> entry : eventTypeMap.entrySet()){
                System.out.println("Event type: " + entry.getKey() + " - Clients: " + entry.getValue());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
