//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            if(arr[i] >= 0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }
        
        if(pos.size() > neg.size()){
            for(int i = 0; i < neg.size(); i++){
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            
            int index = neg.size() * 2;
            for(int i = neg.size(); i < pos.size(); i++){
                arr[index] = pos.get(i);
                index++;
            }
        }
        else{
            for(int i = 0; i < pos.size(); i++){
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            
            int index = pos.size() * 2;
            for(int i = pos.size(); i < neg.size(); i++){
                arr[index] = neg.get(i);
                index++;
            }
        }
    }
}