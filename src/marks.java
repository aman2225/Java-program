import java.util.Scanner;
public class marks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the marks:");
        int n= sc.nextInt();

        if(n>=81) System.out.print("very good");
        else if(n>=61) System.out.print("Good");
        else if(n>=41) System.out.print("Average");
        else System.out.print("Fail");



    }

}
