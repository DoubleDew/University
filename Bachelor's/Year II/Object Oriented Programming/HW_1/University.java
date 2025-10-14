package HW_1;

import java.util.*;
public class University 
{
    private String name;
    private String location;
    private Author authors[] = new Author[50];
    private int numberOfAuthors;

    public University(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.numberOfAuthors = 0;
    }

    public void addAuthor(Author a)
    {
        this.numberOfAuthors++;
        this.authors[numberOfAuthors] = a;
    }

    public double computeScore()
    {
        double sum = 0;
        for(int i = 1; i <= numberOfAuthors ; i++)
            sum += this.authors[i].computeScore();
        return sum;
    }
}
