//15 Write a program to simulate Page replacement algorithm. 1. FIFO
//Input reference String :- 2 3 2 1 5 2 4 5 3 2 5 2
//No. of frames are:- 3
//Design a GUI in python for Help screen of any App.


import java.util.Scanner;

public class SimplestFIFOWithHitRatio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of pages and frame size
        System.out.print("Enter the number of pages: ");
        int numPages = sc.nextInt();
        int[] pages = new int[numPages];

        System.out.print("Enter the reference string (pages): ");
        for (int i = 0; i < numPages; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter the number of frames: ");
        int numFrames = sc.nextInt();

        int[] frames = new int[numFrames];
        int pageFaults = 0, pageHits = 0;
        int index = 0;

        // Initialize frames to -1 (empty)
        for (int i = 0; i < numFrames; i++) {
            frames[i] = -1;
        }

        // FIFO page replacement
        for (int i = 0; i < numPages; i++) {
            int page = pages[i];
            boolean hit = false;

            // Check if page is in any frame (hit check)
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == page) {
                    hit = true;
                    pageHits++;
                    break;
                }
            }

            // If not a hit, replace using FIFO
            if (!hit) {
                frames[index] = page;
                index = (index + 1) % numFrames;  // Move to the next frame in FIFO order
                pageFaults++;
            }

            // Print frames
            System.out.print("Frames: ");
            for (int j = 0; j < numFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }

        // Calculate hit ratio
        float hitRatio = (float) pageHits / numPages;

        // Output results
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Page Hits: " + pageHits);
        System.out.println("Hit Ratio: " + hitRatio);

        sc.close();
    }
}

