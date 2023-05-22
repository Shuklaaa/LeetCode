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
            System.out.println(obj.isPrime(n));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Geeks {
    static String isPrime(int n) {
        boolean flag = false;

        // if n==1
        if (n < 2)
            return "No";
        else {

            for (int i = 2; i <= Math.sqrt(n); i++) {

                // if n has a factor other than
                // 1 and n itself then making
                // flag true
                if (n % i == 0) {
                    flag = true;
                    break;
                }
            }

            // printing "Yes" if
            // it is prime
            // else "No"
            if (flag == false)
                return "Yes";
            else
                return "No";
        }
    }
}