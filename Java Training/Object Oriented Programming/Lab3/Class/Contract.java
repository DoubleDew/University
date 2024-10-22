package Class;

import java.util.*;
import Class.Course.Stream;
import Class.Course.Type;
import java.io.*;

public class Contract implements Storable{
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        this.courses.add(course);
        System.out.println("Added course: " + course.toString());
    }

    public boolean deleteCourse(Type type, Stream stream, String name){
        boolean found = false;
        Course temp = null;
        for(Course c : courses){
            if(c.getName().equalsIgnoreCase(name)){
                found = true;
                temp = c;
            }
        }

        if(temp != null)
            courses.remove(temp);

        return found;
    }

    public void display(){
        for(Course c : courses)
            System.out.println(c.toString());
    }

    public void sort(){
        Collections.sort(courses, new Comparator<Course>(){
            @Override
            public int compare(Course c1, Course c2){
                return c1.getStream().compareTo(c2.getStream());
            }
        });

        Collections.sort(courses, new Comparator<Course>(){
            @Override
            public int compare(Course c1, Course c2){
                return c1.getType().compareTo(c2.getType());
            }
        });

        Collections.sort(courses, new Comparator<Course>(){
            @Override
            public int compare(Course c1, Course c2){
                if(c1.getName().equalsIgnoreCase(c2.getName()) && c1.getType() == c2.getType() && c1.getStream() == c2.getStream())
                    throw new RuntimeException("There are two courses of type: " + c2.getType() + " of " + c2.getStream());
                return c1.getName().compareTo(c2.getName());
            }
        });
    }

    public void store(String file) throws FileNotFoundException{
        FileOutputStream outputFile = new FileOutputStream("contract.txt", true);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println("Contract: ");
        for(Course c : courses)
            pw.println(c.toString() + "\n");
        pw.close();
    }   
}
