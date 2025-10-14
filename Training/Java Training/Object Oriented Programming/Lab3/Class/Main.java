package Class;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Contract c = new Contract();

        // adding courses
        System.out.println("Adding courses to contract...");
        c.addCourse(new Course("Object Oriented Programming", Course.Type.SPECIALIZATION, Course.Stream.ENGLISH, 5));
        c.addCourse(new Course("Money and Banking", Course.Type.DISCIPLINE, Course.Stream.ENGLISH, 2));
        c.addCourse(new Course("Calculus II", Course.Type.FUNDAMENTAL, Course.Stream.FRENCH, 4));
        c.addCourse(new Course("Digital Integrated Circuits", Course.Type.FUNDAMENTAL, Course.Stream.ENGLISH, 3));
        c.addCourse(new Course("Nigga Slavery", Course.Type.FUNDAMENTAL, Course.Stream.GERMAN, 50000));

        System.out.println();
        System.out.println("Courses:");
        c.display();

        System.out.println();
        c.deleteCourse(Course.Type.FUNDAMENTAL, Course.Stream.FRENCH, "Calculus II");
        c.display();

        System.out.println();
        System.out.println("Sorting courses...");
        c.sort();
        System.out.println();
        c.display();

        System.out.println();
        c.store("contract.txt");

    }
    
}
