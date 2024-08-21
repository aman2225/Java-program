import java.io.*;

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class FileHandling2 {
    public static void main(String[] args) {
        // Serialize object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            MyClass obj = new MyClass("John", 30);
            outputStream.writeObject(obj);
            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object.ser"))) {
            MyClass obj = (MyClass) inputStream.readObject();
            System.out.println("Object deserialized: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
