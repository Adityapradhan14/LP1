////14 Write a program to simulate Memory placement strategies – best fit, worst fit.
//Design a GUI in python for Patient Registration Form in Hospital .(Use Text ,Label,Checkbutton,List box etc)

import java.util.Scanner;

public class WorstFit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Input for memory blocks
        System.out.print("Enter number of memory blocks: ");
        int n = sc.nextInt();
        int[] block = new int[n];
        System.out.println("Enter sizes of memory blocks:");
        for (int i = 0; i < n; i++) {
            block[i] = sc.nextInt();
        }
        
        // Input for processes
        System.out.print("Enter number of processes: ");
        int m = sc.nextInt();
        int[] process = new int[m];
        System.out.println("Enter sizes of processes:");
        for (int i = 0; i < m; i++) {
            process[i] = sc.nextInt();
        }
        
        // Worst Fit Allocation
        for (int p : process) {
            int worstIndex = -1;
            
            // Find the largest block that can fit the process
            for (int i = 0; i < n; i++) {
                if (block[i] >= p) {
                    if (worstIndex == -1 || block[i] > block[worstIndex]) {
                        worstIndex = i;
                    }
                }
            }
            
            // Allocate if a suitable block is found
            if (worstIndex != -1) {
                System.out.println("Allocating Process " + p + " to Block " + (worstIndex + 1) + " with size " + block[worstIndex]);
                block[worstIndex] -= p;
                System.out.println("Remaining size in Block " + (worstIndex + 1) + ": " + block[worstIndex]);
            } else {
                System.out.println("Process " + p + " could not be allocated");
            }
        }
        
        sc.close();
    }
}

