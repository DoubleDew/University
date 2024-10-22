package HW_1;

import java.util.*;
public abstract class Publication 
{
    private String name;
    private Calendar apparition;
    private int numberOfAuthors;
    
    public Publication(String name, Calendar apparition, int numberOfAuthors)
    {
        this.name = name;
        this.apparition = apparition;
        this.numberOfAuthors = numberOfAuthors;
    }

    public int getNumberOfAuthors()
    {
        return numberOfAuthors;
    }

    public abstract double computeScore();
}
