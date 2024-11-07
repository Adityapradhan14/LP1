//Write a program to implement Deadlock Avoidance Algorithm
//Design GUI using Python for Cab/Auto Booking App

import java.util.Scanner;

public class bankers {

    static int P; // Number of processes
    static int R; // Number of resources
    static int[][] max;
    static int[][] allocation;
    static int[] available;
    static int[] safeSequence;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Processes:");
        P = sc.nextInt();

        System.out.println("Enter the number of Resources:");
        R = sc.nextInt();

        max = new int[P][R];
        allocation = new int[P][R];
        available = new int[R];
        safeSequence = new int[P];

        System.out.println("Enter the Max matrix:");
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the Allocation matrix:");
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                allocation[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the Available resources:");
        for (int i = 0; i < R; i++) {
            available[i] = sc.nextInt();
        }

        if (isSafe()) {
            System.out.println("The system is in a safe state.");
            System.out.print("Safe sequence is: ");
            for (int i = 0; i < P; i++) {
                System.out.print("P" + safeSequence[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("The system is NOT in a safe state.");
        }
        sc.close();
    }

    static boolean isSafe() {
        boolean[] finished = new boolean[P];
        int[] work = available.clone(); // Clone the available array to work with it
        int count = 0;

        while (count < P) {
            boolean found = false;

            for (int i = 0; i < P; i++) {
                if (!finished[i] && canFinish(i, work)) {
                    for (int j = 0; j < R; j++) {
                        work[j] += allocation[i][j]; // Add allocated resources to work
                    }
                    safeSequence[count] = i;
                    count++;
                    finished[i] = true;
                    found = true;
                }
            }

            if (!found) {
                return false; // If no process can be finished, system is not safe
            }
        }
        return true; // If all processes can be finished, system is safe
    }

    static boolean canFinish(int i, int[] work) {
        for (int j = 0; j < R; j++) {
            if (max[i][j] - allocation[i][j] > work[j]) {
                return false; // If the needed resources exceed available, process cannot finish
            }
        }
        return true; // Process can finish
    }
}

/*
alloc	max
0 1 0    7 5 3
2 0 0	3 2 2
3 0 2	9 0 2
2 1 1	4 2 2
0 0 2	5 3 3

total: 10 5 3
available: 3 3 2
/*

