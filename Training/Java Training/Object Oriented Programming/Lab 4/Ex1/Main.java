import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args){
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person("John", 123556, "New York"));
        personList.add(new Person("Bob", 231234, "Los Angeles"));
        personList.add(new Person("Dan", 654754, "Washington"));
        personList.add(new Person("Harry", 765455, "Boston"));
        personList.add(new Person("March", 645348, "Las Vegas"));

        Iterator<Person> it = personList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        ListIterator<Person> lit = personList.listIterator();
        while(lit.hasNext()){
            System.out.println(lit.next());
        }
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
        }

        lit.next();
        lit.next();
        lit.add(new Person("Tom", 285674, "Chicago"));
        lit.previous();
        lit.previous();

        while (lit.hasNext()){
            System.out.println(lit.next());
        }
    }
}
