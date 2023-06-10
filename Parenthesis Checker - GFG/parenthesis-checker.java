//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<Character>();
        for (char it : x.toCharArray()){
            if(it == '(' ||  it == '{' || it == '['){
                st.push(it);
            }
            else{
                if(st.isEmpty()){ //it means for an opening bracket it does not have any closing bracket
                    return false;
                }
                
                char c = st.pop();
                
                if((it == ')' && c == '(') || (it == '}' && c == '{') || (it == ']' && c == '[')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
