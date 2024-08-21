package Array;

public class sortZeroesOnes {
    //Method 1
    public static void main(String[] args){
        int[] arr={0,0,0,1,1,0,0,0,1,1};
        int n=arr.length;
//        int noOfZeroes= 0;
//        for(int i=0;i<n;i++){
//            if(arr[i]==0) noOfZeroes++;
//        }
//        for(int i=0;i<n;i++){
//            if(i<noOfZeroes) arr[i]=0;
//            else arr[i]=1;
//
//        }
//        for(int i=0;i<n;i++){
//            System.out.print(arr[i]);
//        }
        int i=0, j=n-1;
        while(i<j){
            if(arr[i]==0) i++;    //else if
            if(arr[j]==1) j--;    //else if
            if(i>j) break;
            if(arr[i]==1 && arr[j]==0){ //if(i<j && arr[i]==1 && arr[j]==0  or //else if
                arr[i]=0;
                arr[j]=1;
                i++;
                j--;
            }
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();


    }
}
