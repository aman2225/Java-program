import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();

            int[] arr=new int[105];
            int ol=Math.min(b,d)-Math.max(a,c);

            if(a<c){
                arr[c-1]=1;
            }
            if(c<a){
                arr[a-1]=1;
            }
            if(d>b){
                arr[b]=1;
            }
            if(b>d){
                arr[d]=1;
            }
            int count=0;
            for(int j=1;j<102;j++){
                count=count+arr[j];
            }
            if(ol<0){
                count =0;
            }
            System.out.println(Math.max(1,count + Math.max(0,Math.min(b,d)-Math.max(a,c))));
        }
        sc.close();
    }
}
