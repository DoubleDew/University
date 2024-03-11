public class PersonTest 
{
    public static void main(String args[])
    {
        Person person1 = new Person("Danut", "Deaconu", 20);
        Person person2 = new Person("Ana", "Maria", 19);
        Person person3 = new Person("Irina", "Marinescu", 27);
        Person person4 = new Person("Doru", "Dumi", 22);
        Person person5 = new Person("Razvan", "Deaconu", 54);

        PersonArray array = new PersonArray(5);

        array.insert(person1);
        array.insert(person2);
        array.insert(person3);
        array.insert(person4);
        array.insert(person5);

        array.displayArray();

        Person search = array.search("Vasile");
        if(search != null)
        {
            search.displayPerson();
            System.out.println("Person was found!");
        } else System.out.println("The person was not found!");

        if(array.delete("Deaconu"))
        {
            System.out.println("The person was deleted!");
            array.displayArray();
        }
        else
            System.out.println("The person cannot be found");
    }
}