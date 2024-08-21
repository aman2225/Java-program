package BasicSorting;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr={1,7,3,9,12,13};
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }

        }
        if(flag==true) System.out.println("Sorted");
        else System.out.println("Unsorted");
    }
}
