import java.util.*;

public class Student
{
    private String id;
    private String first_name;
    private String last_name;
    private String group;
    private String cnp;
    private GregorianCalendar bday;
    private Faculty f;
    private int maxvending;
    private List<Vending_Machine> machine = new ArrayList<>();

    public boolean addMachine(Vending_Machine m)
    {
        if(this.machine.size() < this.maxvending)
        {
            this.machine.add(m);
            return true;
        }
        else
            return false;
    }
}

    public Vending_Machine removeMachine(int id)
    {
        Vending_Machine m = null;
        for(Vending_Machine mm : machine)
        {
            if(mm.getID() == id)
            {
                m = mm;
                this.machine.remove(mm);
                System.out.println("The vending machine was removed!");
            }
        }
        return m;
    }
public static void main(String args[])
{
    Faculty f = new Faculty(12, FILS);
    Food food = new Food(50);
    Drinks drinks = new Drinks(50);
    Student stududent = new Student(1606, "Dan", "Deaconu", "12", "1222B", "123456789", new GregorianCalendar(2002, 2, 20));
    
    m.setF(f);
    m.machine.add(food);
    m.machine.add(drinks);
    System.out.println(m.getID);
    food.sell(15);
    for(Vending_Machine mmm : m.machine)
    {
        System.out.println(mmm.getID());
    }
    m.removeMachine(15);
    for(Vending_Machine mmm : m.machine)
    {
        System.out.println(mmm.getID());
    }
}

public Student(int id, String first_name, String last_name, String group, String cnp, GregorianCalendar bday)
{
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.group = group;
    this.cnp = cnp;
    this.bday = bday;
}

public Student(int id, String first_name, String last_name, String group, String cnp, GregorianCalendar bday, Faculty f)
{
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.group = group;
    this.cnp = cnp;
    this.bday = bday;
    this.f = f;
}

public int getID()
{ 
    return id; 
}
public void setID(int id) 
{ 
    this.id = id; 
}

public String getFN()
{
    return first_name;
}
public void setFN(String first_name)
{
    this.first_name = first_name;
}

public String getLN()
{
    return last_name;
}
public void setLN(String last_name)
{
    this.last_name = last_name;
}

public String getGroup()
{
    return group;
}
public void setGroup(String group)
{
    this.group = group;
}

public GregorianCalendar getBday() 
{
    return bday;
}
public void setBday(GregorianCalendar bday) 
{
    this.bday = bday;
}

public String getCNP() 
{
    return cnp;
}

public void setCNP(String cnp) 
{
    this.cnp = cnp;
}

public Faculty getF()
{
    return f;
}
public void setF(Faculty f)
{
    this.f = f;
}

public List<Vending_Machine> getMachine()
{
    return machine;
}
public void setMachine(List<Vending_Machine> machine)
{
    this.machine = machine;
}