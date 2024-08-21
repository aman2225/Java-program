package Array;

public class twosum {
    public static void main(String[] args){
        int[] arr={3,0,8,5,4,9,2};
        int x=9;
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] + arr[j]==x){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
        }
    }
}

//class Solution {
  //  public int[] twoSum(int[] arr, int x) {

   //     int[] ans=new int[2];
    //    int n=arr.length;
    //    for(int i=0;i<n;i++){
      //      boolean flag=false; //optimization
        //    for(int j=i+1;j<n;j++){
          //      if(arr[i]+arr[j]==x){
            //        ans[0]=i;
              //      ans[1]=j;
                //    flag= true;//optimization
                  //  break;
                //}
            //}
            //if(flag== true) break;
        //}
        //return ans;

    //}


//}
