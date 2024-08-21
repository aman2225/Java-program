import java.util.*;
import java.util.Arrays;
public class cf {
    public static boolean isBinary(int a){
        int x = a%10;
        while(a > 0){
            x = a%10;
            if(x != 1 && x != 0) return false;
            a/=10;
        }
        return true;
    }



    public static void main (String[] args)
    {
        ArrayList<Integer> l = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();

        for(int i=1; i<=100000; i++){
            if(isBinary(i)){
                s.add(i); l.add(i);
            } else {
                for(int j=0; j<l.size(); j++){
                    if(i%l.get(j) == 0){
                        if(s.contains(i/l.get(j))){
                            s.add(i); l.add(i);
                            break;
                        }
                    }
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int n = sc.nextInt();
            if(s.contains(n)) System.out.println("YES");
            else System.out.println("NO");

        }
        sc.close();
    }
}