//13 Write a program to simulate Memory placement strategies – best fit, first fit.
//Design a GUI in Python of any screen for fund Tranfer/Transaction.

import java.util.Scanner;

public class FirstFit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input memory blocks
        System.out.print("Enter number of memory blocks: ");
        int n = scanner.nextInt();
        int[] blocks = new int[n];
        System.out.println("Enter sizes of memory blocks:");
        for (int i = 0; i < n; i++) {
            blocks[i] = scanner.nextInt();
        }

        // Input processes
        System.out.print("Enter number of processes: ");
        int m = scanner.nextInt();
        int[] processes = new int[m];
        System.out.println("Enter sizes of processes:");
        for (int i = 0; i < m; i++) {
            processes[i] = scanner.nextInt();
        }

        // First Fit Allocation
        for (int p : processes) {
            boolean allocated = false;
            for (int i = 0; i < n; i++) {
                if (blocks[i] >= p) {
                    blocks[i] -= p;
                    System.out.println("Process " + p + " allocated to block " + (i + 1));
                    allocated = true;
                    break; // Stop after finding the first fit
                }
            }
            if (!allocated) {
                System.out.println("Process " + p + " not allocated");
            }
        }

        scanner.close();
    }
}

