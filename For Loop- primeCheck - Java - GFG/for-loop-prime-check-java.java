//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // take testcases
        int t = sc.nextInt();
        while (t-- > 0) {
            // taking the number
            int n = sc.nextInt();
            Geeks obj = new Geeks();

            // caling isPrime method
            // with n as argument
            obj.isPrime(n);
        }
    }
}

// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Geeks {
    static void isPrime(int n) {
        int flag = 0;
        if(n < 2){
            flag = 1;
        }
        else{
            for (int i = 2; i <= n / 2; i++) {
            if(n % i == 0){
                flag = 1;
                break;
            }
        }
        }
        
        
        if(flag == 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}