package Person;
import java.util.Calendar;

public class Person {
    public String name;
    private String CNP;
    public Calendar birthday;
    private Address address;
    
    public Person(String name, String CNP, Calendar birthday, Address address){
        this.name = name;
        this.CNP = CNP;
        this.birthday = birthday;
        this.address = address;
    }
        
    public void move(Address newAddress){
        address = newAddress;
    }

    public String getName(String name){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getCNP(String CNP){
        return CNP;
    }

    public void setCNP(){
        this.CNP = CNP;
    }

    public Calendar getBirthday(Calendar bday){
        return bday;
    }

    public void setBirthday(){
        this.birthday = birthday;
    }
}
