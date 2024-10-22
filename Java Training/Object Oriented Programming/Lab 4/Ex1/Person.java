public class Person{
    private String name;
    private int cnp;
    private String address;

    public Person(String name, int cnp, String address){
        this.name = name;
        this.cnp = cnp;
        this.address = address;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", CNP: " + cnp + ", Address: " + address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}