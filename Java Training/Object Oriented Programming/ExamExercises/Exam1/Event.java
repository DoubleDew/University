import java.util.GregorianCalendar;

public class Event{
    private int price;
    private GregorianCalendar startDate, endDate;
    private String location;
    private Type type;

    public enum Type{
        WORKSHOP, RETREAT, CONFERENCE, SEMINAR;
    }

    public Event(int price, GregorianCalendar startDate, GregorianCalendar endDate, String location, Type type){
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.type = type;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public GregorianCalendar getStartDate(){
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate){
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate(){
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate){
        this.endDate = endDate;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }

    @Override
    public String toString(){
        return "Event: {" +
            "Price: " + price +
            ", Start Date: " + startDate.getTime() + 
            ", End Date: " + endDate.getTime() + 
            ", Location: " + location +
            ", Type: " + type + 
            "}";
    }

    public boolean overlaps(Event event){
        return startDate.before(event.getEndDate()) && endDate.after(event.getStartDate());
    }

}