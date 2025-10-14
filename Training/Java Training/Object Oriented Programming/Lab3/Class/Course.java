package Class;

public class Course {
    private String name;
    private Type type;
    private Stream stream;
    private int creditPoints;

    public enum Type{
        FUNDAMENTAL, 
        SPECIALIZATION,
        DISCIPLINE;
    }

    public enum Stream{
        ENGLISH, GERMAN, FRENCH;
    }

    // maybe put setType(type) and setStream(stream) in the constructor
    public Course(String name, Type type, Stream stream, int creditPoints) {
        this.name = name;
        this.type = type;
        this.stream = stream;
        this.creditPoints = creditPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String toString(){
        return "Course name: " + name + 
            ", Type: " + type + 
            ", Stream: " + stream +
            ", Credit Points: " + creditPoints;
    }
}
