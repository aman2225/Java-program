// Person2 class with encapsulation
class Person2 {
    private String name;
    private int age;
    private String address;

    // Constructor
    public Person2(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to display information about a person
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddress());
        System.out.println();
    }
}

// Another name for abstract class
abstract class Geometry {
    // Abstract methods for calculating area and perimeter
    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}

// Concrete Circle class extending Geometry with an alias
class AliasCircle extends Geometry {
    private double radius;

    // Constructor
    public AliasCircle(double radius) {
        this.radius = radius;
    }

    // Implementation of abstract methods
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Concrete Rectangle class extending Geometry with an alias
class AliasRectangle extends Geometry {
    private double length;
    private double width;

    // Constructor
    public AliasRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of abstract methods
    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Renamed class with the main method
class App {
    public static void main(String[] args) {
        // Creating objects of the modified Person2 class
        Person2 person1 = new Person2("John Doe", 25, "123 Main St");
        Person2 person2 = new Person2("Jane Smith", 30, "456 Oak Ave");

        // Displaying information about persons using encapsulation
        System.out.println("Person 1 Information:");
        person1.displayInfo();

        System.out.println("Person 2 Information:");
        person2.displayInfo();

        // Modifying data using encapsulation
        person1.setAge(26);
        person2.setAddress("789 Pine Blvd");

        // Displaying updated information
        System.out.println("Updated Person 1 Information:");
        person1.displayInfo();

        System.out.println("Updated Person 2 Information:");
        person2.displayInfo();

        // Creating objects of the abstract class Geometry and its subclasses with aliases to demonstrate abstraction
        Geometry aliasCircle = new AliasCircle(5.0);
        Geometry aliasRectangle = new AliasRectangle(4.0, 6.0);

        // Displaying area and perimeter of shapes using abstraction
        System.out.println("Circle Area: " + aliasCircle.calculateArea());
        System.out.println("Circle Perimeter: " + aliasCircle.calculatePerimeter());

        System.out.println("Rectangle Area: " + aliasRectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + aliasRectangle.calculatePerimeter());
    }
}

