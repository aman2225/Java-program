package strings;

public class StringBuilderInJava {
    public static void main(String[] args) {
        String s="abc";
        StringBuilder sb=new StringBuilder(s);
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        StringBuilder x=new StringBuilder(10);
        System.out.println(x.capacity());
        StringBuilder a=new StringBuilder("");
        System.out.println(a.capacity());
    }
}
