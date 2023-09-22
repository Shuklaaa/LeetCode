//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        // Split the input string into an array of words using dot as delimiter.
        String[] words = S.split("\\.");

        // Reverse the array of words.
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Join the reversed words into a single string with dots as separators.
        StringBuilder reversedString = new StringBuilder();
        for (String word : words) {
            reversedString.append(word).append(".");
        }

        // Remove the trailing dot.
        reversedString.setLength(reversedString.length() - 1);

        return reversedString.toString();
    }
}
