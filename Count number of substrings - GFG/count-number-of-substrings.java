//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    long substrCount(String S, int K) {
        return atmost(S, K) - atmost(S, K - 1);
    }

    long atmost(String s, int k) {
        int[] charCount = new int[26];

        int distinctCount = 0;
        int left = 0;
        long result = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charCount[currentChar - 'a'] == 0) {
                distinctCount++;
            }
            charCount[currentChar - 'a']++;

            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'a']--;
                if (charCount[leftChar - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
