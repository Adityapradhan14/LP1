import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = s.nextInt();

        int[] arrival = new int[n];
        int[] cpu = new int[n];
        int finishTime = 0;
        float totalTurnaround = 0, totalWaiting = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Arrival time of process " + (i + 1) + ": ");
            arrival[i] = s.nextInt();
            System.out.print("CPU time of process " + (i + 1) + ": ");
            cpu[i] = s.nextInt();
        }

        System.out.println("\nProcess\tArrival\tCPU\tFinish\tTurnaround\tWaiting");
        for (int i = 0; i < n; i++) {
            finishTime += cpu[i];
            int turnaround = finishTime - arrival[i];
            int waiting = turnaround - cpu[i];

            totalTurnaround += turnaround;
            totalWaiting += waiting;

            System.out.println((i + 1) + "\t" + arrival[i] + "\t" + cpu[i] + "\t" + finishTime + "\t" + turnaround + "\t\t" + waiting);
        }

        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTurnaround / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWaiting / n);

        s.close();
    }
}

/*
7 Write a program to simulate CPU Scheduling Algorithms: FCFS
Process AT BT
P1 10 2
P2 0 10
P3 8 4
P4 5 5
Design GUI using Python for student Registration Form.(Use Text ,Label,Checkbutton,List box etc)
*/
