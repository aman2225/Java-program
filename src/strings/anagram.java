package strings;

import java.util.Arrays;

public class anagram {
    public static void main(String[] args) {
        String s="anagram";
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        for(char ele:ch){
            System.out.print(ele);
        }
        String t="nagaram";
        char[] arr= t.toCharArray();
        Arrays.sort(arr);
        for(char ele: arr){
            System.out.print(ele);
        }
        
    }
}
