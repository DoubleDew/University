package pp.advanced;

public class MapDemo {
    public static void main(String[] args) {
        MapImpl<String, Integer> ages = new MapImpl<>();

        ages.add("Alice", 25);
        ages.add("Bob", 30);
        ages.add("Charlie", 22);

        System.out.println("Map contents:");
        ages.print();

        System.out.println("\nRemoving Bob...");
        ages.remove("Bob");

        System.out.println("After removal:");
        ages.print();

        System.out.println("\nKeys in map: " + ages.keys());
        System.out.println("Map size: " + ages.size());
        System.out.println("Is empty? " + ages.isEmpty());

        System.out.println("\nTrying to add duplicate key (Alice):");
        ages.add("Alice", 40); // should show warning
    }
}