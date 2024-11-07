import java.util.Scanner;

public class roundrobin {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        System.out.println("Enter no. of processes: ");
        n = sc.nextInt();
        
        int[] arrival = new int[n];
        int[] bus = new int[n];
        int[] remaining = new int[n];
        int[] completion = new int[n];
        
        int totalbus=0;
        int totaltat=0;
        int totalwt=0;
        
        for (int i=0;i<n;i++){
            System.out.println("Enter AT: ");
            arrival[i] = sc.nextInt();
            System.out.println("Enter BT: ");
            bus[i] = sc.nextInt();
            remaining[i] = bus[i];
            totalbus += bus[i];
        }
        
        int tq;
        System.out.println("Enter Time Quantum: ");
        tq = sc.nextInt();
        
        System.out.println("Process execution sequence: ");
        int elapsedtime=0;
        while (elapsedtime < totalbus){
            for (int i=0;i<n;i++){
                if (remaining[i] > 0){
                    int timespent = Math.min(tq,remaining[i]);
                    elapsedtime += timespent;
                    remaining[i] -= timespent;
                    completion[i] = elapsedtime;
                    System.out.print((i + 1) + " ");
                }
            }
        }
         System.out.println();
         
         System.out.println("\nProcess\tArrival\tCPU\tCompletion\tTurnaround\tWaiting");
         for (int i=0;i<n;i++){
             int turnaround = completion[i] - arrival[i];
             int waiting = turnaround - bus[i];
             
             totaltat += turnaround;
             totalwt += waiting;
             
              System.out.printf("P%d\t%d\t%d\t%d\t\t%d\t\t%d\n", 
                              (i + 1), arrival[i], bus[i], completion[i], turnaround, waiting);
         }
         System.out.printf("\nAverage Turnaround Time: %.2f\n", (double) totaltat / n);
        System.out.printf("Average Waiting Time: %.2f\n", (double) totalwt / n);
        
        sc.close();
    }
}

/*
12 Write a program to simulate CPU Scheduling Algorithms: Round Robin. (TQ=1 Sec)
Process AT BT
P1 10 2
P2 0 10
P3 8 4
P4 5 5
Design GUI using Python for customer Feedback Form about Food in Hotel .(Use Text ,Label,Checkbutton, etc)
/*
