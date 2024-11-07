//16 Write a program to simulate Page replacement algorithm. 2. OPTIMAL
//Input reference String :- 2 3 2 1 5 2 4 5 3 2 5 2
//No. of frames are:- 3
//Design a GUI in Python for Welcome screen.


import java.util.Scanner;

public class SimplifiedOptimalPageReplacement {
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

        // Initialize frames to -1 (indicating empty frames)
        for (int i = 0; i < numFrames; i++) {
            frames[i] = -1;
        }

        // Optimal page replacement logic
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

            // If page not found (not a hit), replace the page optimally
            if (!hit) {
                int replaceIndex = -1;
                
                // Check if there's any empty frame (-1 means empty)
                for (int j = 0; j < numFrames; j++) {
                    if (frames[j] == -1) {
                        replaceIndex = j;
                        break;
                    }
                }

                // If no empty frame is found, apply optimal replacement strategy
                if (replaceIndex == -1) {
                    int farthest = -1;
                    for (int j = 0; j < numFrames; j++) {
                        int nextUse = numPages + 1;
                        for (int k = i + 1; k < numPages; k++) {
                            if (pages[k] == frames[j]) {
                                nextUse = k;
                                break;
                            }
                        }
                        if (nextUse > farthest) {
                            farthest = nextUse;
                            replaceIndex = j;
                        }
                    }
                }

                // Replace the frame at 'replaceIndex' with the current page
                frames[replaceIndex] = page;
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

        sc.close();
    }
}


