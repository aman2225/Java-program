import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LAB4MapSetExample {
    public static void main(String[] args) {
        // Using HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("John", 25);
        hashMap.put("Jane", 30);
        hashMap.put("Bob", 22);

        System.out.println("HashMap Elements: " + hashMap);

        // Using HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");

        System.out.println("HashSet Elements: " + hashSet);
    }
}
