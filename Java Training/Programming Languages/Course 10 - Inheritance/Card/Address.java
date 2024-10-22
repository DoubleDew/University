package Card;

public class Address {
    private String city;
    private int number;
    private String street; 

    public Address(String city, int number, String street){
        this.city = city;
        this.number = number;
        this.street = street;
    }

    public String getCity(){
        return city;
    }

    public int getNumber(){
        return number;
    }

    public String getStreet(){
        return street;
    }

    public void setCity(String city){
        this.city = city;
    }
    
    public void setNumber(int number){
        this.number = number;
    }

    public void setStreet(String street){
        this.street = street;
    }
}
