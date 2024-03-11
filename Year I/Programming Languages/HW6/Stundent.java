package HW6;
import java.util.Scanner;

class Student 
{
    private String name;
    private double examMark;
    private double totalp;
    private double meanMark;
    private int numberOfExams;

    public Student(String n, double e, double t, double m)
	{
        name = n;
        examMark = e;
        totalp = t;
        meanMark = m;
    }

    public String getName()
	{
        return name;
    }

    public void addExam(int mark)
	{
        examMark = mark;
        numberOfExams++;
        totalp += examMark;
    }

    public double getTotal()
	{
        return totalp;
    }

    public double getMeanMark()
	{
        meanMark = totalp / numberOfExams;
        return meanMark;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String name;
        double e = 0, t = 0, m = 0;
        int numberOfExams, examMark;

        System.out.println("Enter the name of the student: ");
        name = sc.nextLine();

        Student student = new Student(name, e, t, m);

        System.out.println("How many exam marks do you want to add?");
        numberOfExams = sc.nextInt();

        System.out.println("Enter the marks the student obtained:");
        for(int i = 1; i <= numberOfExams; i++) 
        {
            examMark = sc.nextInt();
            student.addExam(examMark);
        }
        
        System.out.println(student.getName());
        System.out.println(student.getTotal());
        System.out.println(student.getMeanMark());

        sc.close();
    }
}