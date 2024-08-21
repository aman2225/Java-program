package Array;

import java.util.ArrayList;

public class basicsOfArrayList {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(6);
        arr.add(0,10);
        arr.add(1,20);
        arr.add(2,30);
        arr.add(3,40);
        arr.add(4,50);
        arr.add(5,60);
        System.out.print(arr.size());
        System.out.println();
       // System.out.println(arr);
        for(int i=0;i<=5;i++){ //i<arr.size();
          System.out.print(arr.get(i)+" ");
       }
        System.out.println();
        arr.set(2,70);//modify
        for(int i=0;i<=5;i++){
            System.out.print(arr.get(i)+" ");
        }
        arr.add(98);//push back
        System.out.println();
        System.out.print(arr.size());
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }

    }
}
