package BasicSorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 1, -3, 6, 10};
        int n = arr.length;
        //worst case
//        for(int x=1;x<=n-1;x++){
//            for(int i=0;i<n-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp=arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=temp;
//                }
//            }
//        }
        //Bubble sort-2
//        for(int x=0;x<=n-1;x++){
//           for(int i=0;i<n-1-x;i++){
//               if(arr[i]>arr[i+1]){
//                   int temp=arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=temp;
//                }
//            }
//       }
        //Bubble Sort-3 (optimized code pehle se optimized hai)
        for (int x = 0; x <= n - 1; x++) {
            boolean flag=true;
            for (int i = 0; i < n - 1 - x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag =false;
                }
            }
            if (flag == true) break;
        }
        for(int ele: arr){
            System.out.print(ele+" ");
        }
    }
}

