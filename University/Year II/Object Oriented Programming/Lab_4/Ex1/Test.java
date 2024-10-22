package Ex1;
import java.util.*;

public class Test 
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("Deaconu Dan", "123456", "Address 1"));
        people.add(new Person("Popescu Ion", "159753", "Address 2"));
        people.add(new Person("Pop Ioana", "753159", "Address 3"));
        people.add(new Person("Ionescu Rinu", "151789", "Address 4"));
        people.add(new Person("Ion Maria", "798266", "Address 5"));

        Iterator<Person> itr = people.iterator();
        while(itr.hasNext())
        {
             System.out.println(itr.next());
        }

        ListIterator<Person> listItr = people.listIterator();
        
        while(listItr.hasNext()) 
        {
            listItr.next();
        }

        while(listItr.hasPrevious())
        {
            System.out.println(listItr.previous());
        }
    }
}
