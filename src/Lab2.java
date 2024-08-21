public class Lab2 {
    public static void main(String[] args) {
        // declare data types
        System.out.println("Declare Data Types-");
        int a = 5;
        float b = 7.14f;
        char c = 'z';
        boolean d = true;
        String e = "Hello";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        // Arithmetic Operations
        System.out.println("Arithmetic Operations-");
        int x = 10, y = 2;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y);
        System.out.println(x % y);
        System.out.println(++x);
        x++;
        System.out.println(x);

        // Logical Operations
        System.out.println("Logical Operations-");
        int z = 2;
        System.out.println(z < 3 && z < 10);
        System.out.println(z > 3 || z > 10);
        System.out.println(!(z > 0));

        // Relational Operations
        System.out.println("Relational Operations-");
        int p = 10, q = 11, r = 10;
        System.out.println(p == r);
        System.out.println(p != q);
        System.out.println(p < q);
        System.out.println(q > r);
        System.out.println(p >= r);
        System.out.println(r <= q);
    }
}