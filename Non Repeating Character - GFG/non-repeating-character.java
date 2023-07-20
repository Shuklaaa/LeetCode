//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Iterate through the string and count each character occurrence.
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Iterate through the string again to find the first non-repeating character.
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        // If no non-repeating character found, return '$'.
        return '$';
    }
}

