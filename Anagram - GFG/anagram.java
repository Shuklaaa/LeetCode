//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b)
    {
        // If the lengths of the two strings are not equal, they can't be anagrams.
        if (a.length() != b.length()) {
            return false;
        }
        
        // Create arrays to store character frequencies.
        int[] countA = new int[26]; // Assuming only lowercase characters
        int[] countB = new int[26];
        
        // Update the frequency arrays for string 'a'.
        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }
        
        // Update the frequency arrays for string 'b'.
        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }
        
        // Compare the frequency arrays.
        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                return false; // If any character frequency is different, not anagrams.
            }
        }
        
        return true; // If all character frequencies match, they are anagrams.
    }
}
