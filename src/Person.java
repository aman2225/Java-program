public class Person {
    private String name;
    private int age;
    private String address;

    // Constructor
    public Person(String name, int age, String address) {
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
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating instances of the Person class
        Person person1 = new Person("Aman", 25, "123 Main St");
        Person person2 = new Person("Smith", 30, "456 Oak Ave");

        // Displaying information about the persons
        System.out.println("Person 1 Information:");
        person1.displayInfo();

        System.out.println("Person 2 Information:");
        person2.displayInfo();

        // Modifying data using setters
        person1.setAge(26);
        person2.setAddress("789 Pine Blvd");

        // Displaying updated information
        System.out.println("Updated Person 1 Information:");
        person1.displayInfo();

        System.out.println("Updated Person 2 Information:");
        person2.displayInfo();
    }
}
