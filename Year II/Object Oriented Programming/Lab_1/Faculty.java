package Lab_1;

public class Faculty 
{
    private int id;
    private String name;

    public Faculty(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getID()
    { 
        return id; 
    }
    public void setID(int id) 
    { 
        this.id = id; 
    }

    public String getName() 
    { 
        return name; 
    }
    public String setName (String name) 
    { 
        this.name = name; 
    }
}