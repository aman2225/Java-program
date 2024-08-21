package Array;

import java.util.Arrays;

public class builtinmethod {
    public static void main(String[] args){
        int[] arr={50,39,30,20};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        Arrays.sort(arr);
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
