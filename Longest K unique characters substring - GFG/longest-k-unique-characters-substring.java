//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int[] charCount = new int[26]; // to store the frequency of characters
        int uniqueChars = 0; // count of unique characters in the current window
        int maxLength = -1; // length of the longest substring with K unique characters
        int left = 0; // left pointer of the sliding window
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If this character is not seen before in the current window, increment uniqueChars
            if (charCount[c - 'a'] == 0) {
                uniqueChars++;
            }
            
            charCount[c - 'a']++; // Increment the character count
            
            // Adjust the left pointer if there are more than K unique characters in the window
            while (uniqueChars > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'a']--;
                
                if (charCount[leftChar - 'a'] == 0) {
                    uniqueChars--;
                }
                
                left++;
            }
            
            // Update maxLength if the current window has exactly K unique characters
            if (uniqueChars == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        return maxLength;
    }
}
