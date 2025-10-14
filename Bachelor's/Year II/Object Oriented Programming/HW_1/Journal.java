package HW_1;

import java.util.*;
public class Journal extends Publication
{
    private String journalName;
    private double impactFactor;

    public Journal(String journalName, String name, Calendar apparition, int numberOfAuthors, double impactFactor)
    {
        super(name, apparition, numberOfAuthors);
        this.journalName = journalName;
        this.impactFactor = impactFactor;
    }

    @Override
    public double computeScore()
    {
        return (this.impactFactor * 0.5) / super.getNumberOfAuthors();
    }
}
