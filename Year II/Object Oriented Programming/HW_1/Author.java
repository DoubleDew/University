package HW_1;

import java.util.*;
public class Author 
{
    private String name;
    private University university;
    private Publication[] publications = new Publication[50];
    private int numberOfPublications;
    
    public Author(String name, University university)
    {
        this.university = university;
        this.name = name;
        this.numberOfPublications = 0;
    }

    public void addPublication(Publication p)
    {
        this.numberOfPublications ++;
        this.publications[numberOfPublications] = p;
    }

    public double computeScore()
    {
        double sum = 0;
        for(int i = 1; i <= numberOfPublications; i++)
            sum += this.publications[i].computeScore();
        return sum;
    }

    public static void main(String args[])
    {
        University university = new University("Poli", "Bucharest");
        Author author = new Author ("Danut", university);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2022, calendar.OCTOBER, 16);

        Publication publication = new ConferenceProceeding("Homework 1", true, "OOP", calendar, 1);

        university.addAuthor(author);
        author.addPublication(publication);
        System.out.println(author.computeScore());
        System.out.println(university.computeScore());
    }
}