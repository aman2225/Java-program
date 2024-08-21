import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LAB4ListExample {
    public static void main(String[] args) {
        // Using ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");

        System.out.println("ArrayList Elements: " + arrayList);

        // Using LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Blue");

        System.out.println("LinkedList Elements: " + linkedList);
    }
}

