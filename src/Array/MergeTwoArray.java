package Array;

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] a={11,35,42,71};
        int[] b={26,54,69,81};
        int[] c=new int[a.length + b.length];
        int i=0,j=0,k=0;
        //
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
            }
            else{
                c[k]=b[j];
                j++;
            }
            k++;

        }
        if(i==a.length){
            while(j<b.length){
                c[k]=b[j];
                j++;k++;
            }

        }
        if(j==a.length){
            while(i<a.length){
                c[k]=a[i];
                j++;k++;
            }
        }
        for(int ele: c){
            System.out.print(ele+" ");
        }
    }
}
