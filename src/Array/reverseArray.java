package Array;

public class reverseArray {
    public static void main(String[] args) {
        // int[] arr = {10, 20, 30, 40, 50, 60,70};
        int[] arr = {10, 20, 30, 40, 50, 60};
        int n = arr.length;
//        for (int i = 0; i < n/2; i++) {
//            int temp = arr[i];
//            arr[i]=arr[n-1-i];
//            arr[n-1-i]=temp;
//        }
//        for(int i=0;i<n;i++){
//        //for(int ele : arr){
//            System.out.print(arr[i]+" ");
//        }

//        int i=0; int j=n-1;
//        while(i<=j){
//            int temp =arr[i];
//            arr[i]=arr[j];
//            arr[j]=temp;
//            i++;
//            j--;
//        }
//        for(int k=0;k<n;k++){
//            System.out.print(arr[k]+" ");
//        }
//    }
        int i=0,j=n-1;  //agar mujhe bich se reverse karna ho toh i=1(1is index) j=5; kha se kha tak reverse karna hai
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }
        public static void swap(int[] arr,int i,int j){
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
