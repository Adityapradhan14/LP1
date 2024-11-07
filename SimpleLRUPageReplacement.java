//17 Write a program to simulate Page replacement algorithm. 3. LRU
//Input reference String :- 2 3 2 1 5 2 4 5 3 2 5 2
//No. of frames are:- 3
//Design a GUI in python for Sports Academy Registration Form

import java.util.Scanner;

public class SimpleLRUPageReplacement {
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
        int[] lastUsed = new int[numFrames]; // To track when each frame was last used
        int pageFaults = 0, pageHits = 0;

        // Initialize frames and last used times
        for (int i = 0; i < numFrames; i++) {
            frames[i] = -1;   // -1 indicates the frame is empty
            lastUsed[i] = -1; // -1 indicates it hasn't been used yet
        }

        // LRU page replacement logic
        for (int i = 0; i < numPages; i++) {
            int page = pages[i];
            boolean hit = false;

            // Check if page is in any frame (hit check)
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == page) {
                    hit = true;
                    pageHits++;
                    lastUsed[j] = i;  // Update the last used time
                    break;
                }
            }

            // If page not found (not a hit), replace the least recently used page
            if (!hit) {
                int replaceIndex = -1;
                int leastRecentlyUsed = numPages + 1;

                // Find the least recently used page
                for (int j = 0; j < numFrames; j++) {
                    if (frames[j] == -1) {  // If frame is empty, use it directly
                        replaceIndex = j;
                        break;
                    }
                    // Find the frame with the oldest last used time
                    if (lastUsed[j] < leastRecentlyUsed) {
                        leastRecentlyUsed = lastUsed[j];
                        replaceIndex = j;
                    }
                }

                // Replace the frame at 'replaceIndex' with the current page
                frames[replaceIndex] = page;
                lastUsed[replaceIndex] = i;  // Update the last used time
                pageFaults++;
            }

            // Print frames
            System.out.print("Frames: ");
            for (int j = 0; j < numFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }

        // Output results
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Page Hits: " + pageHits);

        // Calculate and print hit ratio
        double hitRatio = (double) pageHits / numPages;
        System.out.println("Hit Ratio: " + hitRatio);

        sc.close();
    }
}

