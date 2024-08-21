package Array;

import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Array size");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter Array element");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int mx=arr[0];// or int mx=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){ // int i=0
            if(arr[i]>mx){ // or mx=Math.max(mx,arr[i])
                mx=arr[i];
            }

        }
        System.out.println(mx);
    }
}
