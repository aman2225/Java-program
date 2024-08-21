
import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
class Pair implements Comparable<Pair> {
    int ind, a, b;

    public Pair(int ind, int a, int b) {
        this.ind = ind;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair p2) {
        if (this.b == p2.b) return this.a - p2.a;
        return this.b - p2.b;
    }
}

public class oslab {


    public static void SJF2(int arrival[], int burst[]){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int n = arrival.length;
        int arr[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = arrival[i];
            arr[i][2] = burst[i];
        }

        Arrays.sort(arr, (a,b) -> a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]);

        int ans[][] = new int[n][5];
        int rt[] = new int[n]; Arrays.fill(rt, Integer.MAX_VALUE);
        int ct = 0, i=0, k = 1;



        while(ct >= 0){
            if(arr[i][1] <= ct){
                q.add(new Pair(arr[i][0], arr[i][1], arr[i][2]));
            } else ct++;
            while(!q.isEmpty()){
                Pair curr = q.remove();
                //System.out.println(curr.ind + " " + curr.a + " " + curr.b);
                rt[curr.ind] = Math.min(ct-curr.a, rt[curr.ind]);
                ct += 1;
                if(curr.b == 1 && i<n) {ans[i][0] = ct; ans[i][3] = curr.ind; i++;}
                else { q.add(new Pair(curr.ind, curr.a, curr.b-1));}
                if(k < n){
                    while(k <n && arr[k][1] <= ct){
                        q.add(new Pair(arr[k][0], arr[k][1],arr[k][2]));
                        k++;
                    }
                }
            }
            if(i == n) break;
        }
        Arrays.sort(ans, (a,b) -> a[3] - b[3] ); Arrays.sort(arr, (a,b) -> a[0] - b[0] );

        for(int j=0; j<n; j++){
            ans[j][1] = ans[j][0] - arr[j][1];
            ans[j][2] = ans[j][1] - arr[j][2];
        }

        int aw = 0, att = 0, ars = 0;

        for(int j=0; j<n; j++){
            ars += rt[j];
        }

        System.out.println("   Process No.\t  ArrivalTime\t BurstTime  Completion Time  Turn Around Time  Waiting Time  Response Time");
        for(int j = 0; j<n; j++){
            System.out.println("\tP"+ans[j][3] + "\t\t  " + arr[j][1] + "\t     " + arr[j][2] + " \t\t" + ans[j][0] + " \t\t  " + ans[j][1] + " \t\t  " + ans[j][2] + " \t\t" + rt[j]);
            att += ans[j][1];
            aw += ans[j][2];
        }
        System.out.println();
        System.out.println();

        System.out.println("Average Turn Around Time = " + ((double)att/n));
        System.out.println("Average Waiting Time = " + ((double)aw/n));
        System.out.println("Average Response Time = " + ((double)ars/n));
    }

    public static void main(String args[]) {
        //int arrival[] = {0,1,5,6}; int burst[] = {2,2,3,4}; FCFS(arrival, burst);

        //int arrival1[] = {1,2,1,4}; int burst1[] = {3,4,2,4}; SJF1(arrival1, burst1);

        int arrival2[] = {0, 1, 2, 4};
        int burst2[] = {5, 3, 4, 1};
        SJF2(arrival2, burst2);
        //int arrival3[] = {0,1,3,4,5,6,10}; int burst3[] = {8,2,4,1,6,5,1}; int priority[] = {3,4,4,5,2,6,1}; priority1(arrival3, burst3, priority);
        //int arrival3[] = {0,1,3,4,5,6,10}; int burst3[] = {8,2,4,1,6,5,1}; int priority[] = {3,4,4,5,2,6,1}; priority2(arrival3, burst3, priority);
    }
}
