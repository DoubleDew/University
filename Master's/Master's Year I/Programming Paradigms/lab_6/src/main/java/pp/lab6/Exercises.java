package pp.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises {

    public List<Integer> exercise1(List<Integer> list){
        return list.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .collect(Collectors.toList());
    }

    public int exercise2(List<Integer> list){
        return list.stream()
            .map(n -> n * n)
            .reduce(0, (a, b) -> a + b);
    }

    public Map<Integer, Integer> exercise3a(List<String> list){
        if (list == null)
            return  new HashMap<>();

        return list.stream()
            .collect(Collectors.groupingBy(
                String::length,
                Collectors.summingInt(s -> 1)
            ));
    }

    public Map<Integer, Integer> exercise3b(List<String> list){
        Map<Integer, Integer> result = new HashMap<>();
        
        if(list == null)
            return result;

        for(String s : list){
            int len = (s == null) ? 0 : s.length();
            result.put(len, result.getOrDefault(len, 0) + 1);
        }
        return result;
    }

    public List<String> exercise4(List<List<String>> listOfLists){
        return listOfLists.stream()
            .flatMap(innerList -> innerList.stream())
            .distinct()
            .collect(Collectors.toList());
    }

    public static class Student1{
        private final int id;
        private final String name;
        private final String group;

        public Student1(int id, String name, String group){
            this.id = id;
            this.name = name;
            this.group = group;
        }

        public int getId() {return id;}
        public String getName() {return name;}
        public String getGroup() {return group;}

        @Override
        public String toString() {return name;}
    }

    public static class Student{
        private final int id;
        private final String name;
        private final String group;
        private final List<Course> courses;

        public Student(int id, String name, String group, List<Course> courses){
            this.id = id;
            this.name = name;
            this.group = group;
            
            //comment for ex5, leave as is for ex7
            this.courses = courses;
        }

        public int getId() {return id;}
        public String getName() {return name;}
        public String getGroup() {return group;}
        public List<Course> getCourses() {return courses;}

        @Override
        public String toString() {return name;}
    }

    public static class Course{
        private final int id;
        private final String name;
        private final int credits;
        private final List<Student> students = new ArrayList<>();

        public Course(int id, String name, int credits){
            this.id = id;
            this.name = name;
            this.credits = credits;
        }
        
        public int getId() {return id;}
        public String getName() {return name;}
        public int getCredits() {return credits;}
        public List<Student> getStudent() {return students;}
    }

    public String exercise5(List<Student1> students, String groupName){
        return students.stream()
            .filter(s -> s.getGroup().equals(groupName))
            .map(Student1::getName)
            .collect(Collectors.joining(", "));
    }

    private static final List<Integer> largeList = IntStream.rangeClosed(1, 200_000)
                                            .boxed()
                                            .collect(Collectors.toList());

    public static long exercise6a(){
        long start = System.nanoTime();

        long sum = largeList.stream()
                    .mapToLong(n -> (long)n * n)
                    .sum();

        long end = System.nanoTime();
        long elapsed = end - start;

        System.out.println("Sequential: " + elapsed / 1_000_000 + "ms");
        return sum;
    }

    public static long exercise6b(){
        long start = System.nanoTime();

        long sum = largeList.parallelStream()
                    .mapToLong(n -> (long)n * n)
                    .sum();

        long end = System.nanoTime();
        long elapsed = end - start;

        System.out.println("Parallel: " + elapsed / 1_000_000 + "ms");
        return sum;
    }

    public List<Student> exercise7(List<Student> students){
        return students.stream()
                    .filter(s -> s.getCourses() != null && s.getCourses().stream().anyMatch(c -> c.getCredits() > 5))
                    .collect(Collectors.toList());
    }

    public List<Student> exercise8(List<Student> students){
        return students.stream()
                    .filter(s -> s.getCourses() != null && 
                            s.getCourses().stream()
                                        .mapToInt(Course::getCredits)
                                        .sum() > 30)
                    .collect(Collectors.toList());
    }

    public Map<Integer, List<Integer>> exercise9(List<Course> courses){
        return courses.stream()
                    .collect(Collectors.toMap(
                        Course::getId,
                        c -> c.getStudent().stream()
                                    .map(Student::getId)
                                    .collect(Collectors.toList())
                    ));
    }

    public List<Student> exercise10(List<Student> students, String groupName){
        return students.stream()
                    .filter(s -> s.getGroup().equals(groupName))
                    .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                    .limit(5)
                    .collect(Collectors.toList());
    }

    public Map<String, List<Course>> exercise11(List<Student> students){
        return students.stream()
                    .collect(
                        Collectors.groupingBy(
                            Student::getGroup,
                            Collectors.collectingAndThen(
                                Collectors.flatMapping(
                                    s -> s.getCourses().stream(),
                                    Collectors.toCollection(LinkedHashSet::new)
                                ),
                                list -> list.stream().distinct().collect(Collectors.toList()))
                        )
                    );
    }

    public static void main(String[] args) {
        Exercises ex = new Exercises();

        System.out.println("\n--------------------------------");

        //exercise 1
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Expected output for exercise 1: [4, 16, 36, 64, 100]");
        System.out.println(ex.exercise1(list));

        System.out.println("\n--------------------------------");

        //exercise 2
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Expected output for exercise 2: 55");
        System.out.println("Output: " + ex.exercise2(list2));

        System.out.println("\n--------------------------------");

        //exercise 3
        List<String> list3 = Arrays.asList("apple", "banana", "pear", "kiwi", "plum", "fig", "grape", "melon");
        System.out.println("Expected output for exercise 3: {3=1, 4=3, 5=3, 6=1}");
        System.out.println("Solution 1: " + ex.exercise3a(list3));
        System.out.println("Solution 2: " + ex.exercise3b(list3));

        System.out.println("\n--------------------------------");

        //exercise 4
        List<List<String>> list4 = List.of(
            List.of("apple", "banana", "kiwi"),
            List.of("banana", "orange", "watermelon"),
            List.of("orange", "kiwi", "grapefruit")
        );

        System.out.println("Expected output for exercise 4: [apple, banana, kiwi, orange, watermelon, grapefruit]");
        System.out.println("Output: " + ex.exercise4(list4));

        System.out.println("\n--------------------------------");

        //exercise 5 - commented for ex7 to work without much hassle
        List<Student1> list5 = Arrays.asList(
            new Student1(1, "Alice", "1262"),
            new Student1(2, "Bob", "1263"),
            new Student1(3, "Mark", "1263"),
            new Student1(4, "Wade", "1263"),
            new Student1(5, "Michael", "1264")
        );

        // try for group "1263"
        String groupName = "1263";
        System.out.println("Expected output for exercise 5: Bob, Mark, Wade");
        System.out.println("Output: " + ex.exercise5(list5, groupName));

        System.out.println("\n--------------------------------");

        //exercise 6
        long seq = Exercises.exercise6a();
        long par = Exercises.exercise6b();

        System.out.println("Sequential sum: " + seq);
        System.out.println("Parallel sum: " + par);

        System.out.println("\n--------------------------------");

        // exercise 7
        Course math = new Course(1, "Math", 6);
        Course phys = new Course(2, "Physics", 3);
        Course prog = new Course(3, "Programming", 8);

        List<Student> list7 = Arrays.asList(
            new Student(1, "Bob", "1263", Arrays.asList(phys)),
            new Student(2, "Mark", "1263", Arrays.asList(math, prog)),
            new Student(3, "Wade", "1263", Arrays.asList(prog))
        );

        System.out.println("Expected output for exercise 7: Mark, Wade");
        System.out.println("Output: " + ex.exercise7(list7));

        System.out.println("\n--------------------------------");

        //exercise 8
        Course math1 = new Course(1, "Math", 10);
        Course phys1 = new Course(2, "Physics", 12);
        Course chem1 = new Course(3, "Chemistry", 8);
        Course prog1 = new Course(4, "Programming", 15);

        List<Student> list8 = Arrays.asList(
            new Student(1, "Bob", "1263", Arrays.asList(chem1, phys1)),
            new Student(2, "Mark", "1263", Arrays.asList(math1, prog1)),
            new Student(3, "Wade", "1263", Arrays.asList(math1, chem1)),
            new Student(4, "Dan", "1263", Arrays.asList(prog1, math1, phys1))
        );

        System.out.println("Expected output for exercise 8: Dan");
        System.out.println("Output: " + ex.exercise8(list8));

        System.out.println("\n--------------------------------");

        //exercise 9
        Course math2 = new Course(1, "Math", 10);
        Course phys2 = new Course(2, "Physics", 12);
        Course prog2 = new Course(3, "Programming", 15);

        
        List<Student> list9 = Arrays.asList(
            new Student(1, "Bob", "1263", Arrays.asList(phys2)),
            new Student(2, "Mark", "1263", Arrays.asList(math2, prog2)),
            new Student(3, "Wade", "1263", Arrays.asList(math2)),
            new Student(4, "Dan", "1263", Arrays.asList(prog2, math2, phys2))
        );

        for (Student s : list9) {
            for (Course c : s.getCourses()) {
                c.getStudent().add(s);
            }
        }

        List<Course> courses = Arrays.asList(math2, phys2, prog2);
        Map<Integer, List<Integer>> result = ex.exercise9(courses);

        result.forEach((k, v) -> {
            System.out.println("Course ID: " + k + " -> Student IDs: " + v);
        });
        
        System.out.println("\n--------------------------------");
        
        //exercise 10
        Course math3 = new Course(1, "Math", 10);
        Course phys3 = new Course(2, "Physics", 12);
        Course prog3 = new Course(3, "Programming", 15);

        List<Student> list10 = Arrays.asList(
            new Student(1, "Bob", "1263", Arrays.asList(phys3)),
            new Student(2, "Mark", "1263", Arrays.asList(math3, prog3)),
            new Student(3, "Wade", "1263", Arrays.asList(math3)),
            new Student(4, "Dan", "1263", Arrays.asList(prog3, math3, phys3)),
            new Student(5, "Luiza", "1263", Arrays.asList(math3, phys3)),
            new Student(6, "Matt", "1263", Arrays.asList(prog3, math3))
        );

        for (Student s : list10) {
            for (Course c : s.getCourses()) {
                c.getStudent().add(s);
            }
        }

        System.out.println("Expected output for exercise 10: Bob, Dan, Luiza, Mark, Matt");
        System.out.println("Output: " + ex.exercise10(list10, "1263"));

        System.out.println("\n--------------------------------");

        //exercise 11
        Course math4 = new Course(1, "Math", 10);
        Course phys4 = new Course(2, "Physics", 12);
        Course prog4 = new Course(3, "Programming", 15);
        Course chem4 = new Course(4, "Chemistry", 5);

        List<Student> list11 = Arrays.asList(
            new Student(1, "Bob", "1261", Arrays.asList(phys4, chem4)),
            new Student(2, "Mark", "1263", Arrays.asList(math4, prog4)),
            new Student(3, "Wade", "1262", Arrays.asList(math4, chem4)),
            new Student(4, "Dan", "1263", Arrays.asList(prog4, math4, phys4)),
            new Student(5, "Luiza", "1262", Arrays.asList(math4, phys4)),
            new Student(6, "Matt", "1261", Arrays.asList(prog4, math4, chem4))
        );

        for (Student s : list11) {
            for (Course c : s.getCourses()) {
                c.getStudent().add(s);
            }
        }

        Map<String, List<Course>> result11 = ex.exercise11(list11);
        
        result11.forEach((group, courseList) -> {
            System.out.print("Group " + group + " -> ");
            System.out.println(
                courseList.stream()
                    .map(Course::getName)
                    .collect(Collectors.joining(", "))
            );
        });
    }
}