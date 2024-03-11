public class PersonArray 
{
    private Person[] person = new Person[100];
    private int noPersons;

    public PersonArray(int noPersons)
    {
        this.noPersons = 0;
    }

    public void insert(Person newPerson)
    {
        this.person[noPersons] = newPerson;
        this.noPersons++;
    }

    public Person search(String searchName)
    {
        for(int i = 0; i < noPersons; i++)
            if(searchName.equals(person[i].getLast()))
                return person[i];
            return null;
    }

    public boolean delete(String searchName)
    {
        boolean deletion = false;
        for(int i = 0, k = 0; i < noPersons; i++) {
            if (searchName.equals(person[i].getLast())) {
                deletion = true;
                continue;
            }
            person[k++] = person[i];
        }
        noPersons--;
        return deletion;
    }

    public void displayArray()
    {
        for(int i = 0; i < noPersons; i++)
        {
            person[i].displayPerson();
        }
    }
}