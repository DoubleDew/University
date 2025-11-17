package pp.advanced;

public class StackDemo {
    public static void main(String[] args) {
        // Stack of Strings
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Chair");
        stringStack.push("Dog");
        stringStack.push("Computer");

        System.out.println("\nString Stack:");
        stringStack.print();

        System.out.println("Popped: " + stringStack.pop());
        System.out.println("After popping one element:");
        stringStack.print();

        // Stack of Persons
        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Danut", 23));
        personStack.push(new Person("Razvan", 36));
        personStack.push(new Person("Luiza", 23));

        System.out.println("\nPerson Stack:");
        personStack.print();

        System.out.println("Popped: " + personStack.pop());
        System.out.println("Peeked: " + personStack.peek());
        System.out.println("After popping one element:");
        personStack.print();

        // Remove all elements
        while (!personStack.isEmpty()) {
            personStack.pop();
        }

        System.out.println("After removing all elements:");
        personStack.print();
    }
}