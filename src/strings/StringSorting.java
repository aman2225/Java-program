package strings;

import java.util.Arrays;

public class StringSorting {
    public static void main(String[] args) {
        String s="aman";
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        for(char ele: ch){
            System.out.print(ele);
        }
        System.out.println();
        StringBuilder sb=new StringBuilder("kumar");
        char[] arr= sb.toString().toCharArray();
        Arrays.sort(arr);
        for(char ele:arr){
            System.out.print(ele);
        }
    }
}
