import java.util.Scanner;

public class SJF {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = s.nextInt();

        int[] arrival = new int[n], cpu = new int[n], finish = new int[n];
        int[] turnaround = new int[n], waiting = new int[n], process = new int[n];
        float totalTurnaround = 0, totalWaiting = 0;

        // Input arrival and CPU times, assign process IDs
        for (int i = 0; i < n; i++) {
            System.out.print("Arrival time of Process " + (i + 1) + ": ");
            arrival[i] = s.nextInt();
            System.out.print("CPU time of Process " + (i + 1) + ": ");
            cpu[i] = s.nextInt();
            process[i] = i + 1; // Store original process ID
        }

        // Sort by CPU time (Shortest Job First), keeping track of original IDs
        //Bubble sort, sorts the processes based on their CPU times 
        //The outer loop runs through each process, and the inner loop compares it with the subsequent processes to find the shortest CPU time.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cpu[i] > cpu[j]) {
                    // Swap all details for SJF order, including process ID
                    int temp = cpu[i]; cpu[i] = cpu[j]; cpu[j] = temp;
                    temp = arrival[i]; arrival[i] = arrival[j]; arrival[j] = temp;
                    temp = process[i]; process[i] = process[j]; process[j] = temp;
                }
            }
        }

        int currentTime = 0;
        
        // Calculate finish, turnaround, and waiting times
        for (int i = 0; i < n; i++) {
            if (currentTime < arrival[i]) currentTime = arrival[i]; 
            //If currentTime is less than arrival[i], it means the CPU is currently idle and has to wait until the process arrives.
	    //By setting currentTime = arrival[i], we "fast-forward" to the arrival time of the next process, 
	    //meaning the CPU is ready to start the process as soon as it arrives.
            currentTime += cpu[i];
            finish[i] = currentTime;
            turnaround[i] = finish[i] - arrival[i];
            waiting[i] = turnaround[i] - cpu[i];

            totalTurnaround += turnaround[i];
            totalWaiting += waiting[i];
        }

        // Output results, referencing original process IDs
        System.out.println("\nProcess\tArrival\tCPU\tFinish\tTurnaround\tWaiting");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + process[i] + "\t" + arrival[i] + "\t" + cpu[i] + "\t" + finish[i] +
                               "\t" + turnaround[i] + "\t\t" + waiting[i]);
        }
        
        // Display average turnaround and waiting times
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTurnaround / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWaiting / n);
    }
}

/*
8 Write a program to simulate CPU Scheduling Algorithms: SJF (Preemptive)
Process AT BT
P1 10 2
P2 0 10
P3 8 4
P4 5 5
Design Paper Prototyping for any Shopping App or Website.

9 Write a program to simulate CPU Scheduling Algorithms: SJF (Non-Preemptive)
Process AT BT
P1 10 2
P2 0 10
P3 8 4
P4 5 5
Design GUI using Python for Login Window.
*/
*/

