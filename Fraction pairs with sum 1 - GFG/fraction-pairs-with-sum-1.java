//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        int count = 0;
        HashMap<Float,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            float x = numerator[i]*1f/denominator[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // System.out.println(map);
        for(int i=0;i<n;i++){
            float x = (1*denominator[i]-numerator[i])*1f/denominator[i];
            float y = numerator[i]*1f/denominator[i];
            map.put(y, map.getOrDefault(y, 0) - 1);
            // System.out.println("X : "+x+"       Y : "+y);
            // System.out.println(map);
            if(map.containsKey(x) && map.get(x)>0){
                count+= map.get(x);
                // map.remove(x);
            }
            // System.out.println(map+"  "+count);
            // System.out.println();
        }
        return count;
    }
}
