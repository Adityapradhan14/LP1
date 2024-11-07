import java.util.Scanner;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of processes
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();

        // Initialize arrays to hold arrival times, burst times, priorities, etc.
        int[] arrival = new int[n];
        int[] burst = new int[n];
        int[] priority = new int[n];
        int[] turnaround = new int[n];
        int[] waiting = new int[n];
        int[] completion = new int[n];
        boolean[] isCompleted = new boolean[n];
        int[] process = new int[n];

        // Taking inputs
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time for process " + (i + 1) + ":");
            arrival[i] = sc.nextInt();
            System.out.println("Enter burst time for process " + (i + 1) + ":");
            burst[i] = sc.nextInt();
            System.out.println("Enter priority for process " + (i + 1) + " (lower value = higher priority):");
            priority[i] = sc.nextInt();
            process[i] = i + 1;
        }

        int currentTime = 0;
        int completed = 0;
        int totalTAT = 0;
        int totalWT = 0;

        while (completed < n) {
            int highestPriority = Integer.MAX_VALUE;
            int chosenProcess = -1;

            // Find the highest priority process that has arrived and is not completed
            for (int i = 0; i < n; i++) {
                if (arrival[i] <= currentTime && !isCompleted[i] && priority[i] < highestPriority) {
                    highestPriority = priority[i];
                    chosenProcess = i;
                }
            }

            if (chosenProcess == -1) {
                currentTime++;
            } else {
                // Process execution
                currentTime += burst[chosenProcess];
                completion[chosenProcess] = currentTime;
                turnaround[chosenProcess] = completion[chosenProcess] - arrival[chosenProcess];
                waiting[chosenProcess] = turnaround[chosenProcess] - burst[chosenProcess];

                // Mark as completed
                isCompleted[chosenProcess] = true;
                completed++;

                // Update total TAT and WT
                totalTAT += turnaround[chosenProcess];
                totalWT += waiting[chosenProcess];
            }
        }

        // Display the results
        System.out.println("\nProcess\tAT\tBT\tPriority\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t\t%d\t%d\n", process[i], arrival[i], burst[i], priority[i], turnaround[i], waiting[i]);
        }

        // Display average TAT and WT
        System.out.printf("\nAverage Turnaround Time: %.2f", (double) totalTAT / n);
        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWT / n);

        sc.close();
    }
}

/*
11 Write a program to simulate CPU Scheduling Algorithms: Priority (Non-Preemptive).
Process AT BT
P1 10 2
P2 0 10
P3 8 4
P4 5 5
Design GUI using Python for sign-up Window

10 Design GUI using Python for online Quiz.(Use Text ,Label,Checkbutton, etc)
/*
