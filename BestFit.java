//14 Write a program to simulate Memory placement strategies – best fit, worst fit.
//Design a GUI in python for Patient Registration Form in Hospital .(Use Text ,Label,Checkbutton,List box etc)

//13 Write a program to simulate Memory placement strategies – best fit, first fit.
//Design a GUI in Python of any screen for fund Tranfer/Transaction.

import java.util.Scanner;

public class BestFit {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of memory blocks: ");
        int n;
        n= sc.nextInt();
        
        int[] block = new int[n];
        System.out.println("Enter the Blocks of memory: ");
        for (int i=0;i<n;i++){
            block[i] = sc.nextInt();
        }
        
        System.out.println("Enter the number of Processes: ");
        int m;
        m= sc.nextInt();
        
        int[] process = new int[m];
        System.out.println("Enter process: ");
        for (int i=0;i<m;i++){
            process[i] = sc.nextInt();
        }
        
        for (int p : process){
            int bestindex=-1;
            
            for (int i=0;i<n;i++){
                if (block[i] >= p){
                    if (bestindex == -1 || block[i] < block[bestindex]){
                        bestindex=i;
                    }
                }
            }
            if (bestindex != -1){
                block[bestindex] -= p;
                System.out.println("Process " + p + " allocated to block " + (bestindex + 1));
            }else{
                 System.out.println("Process " + p + " not allocated");
            }
        }
        sc.close();
        
    }
    
}
