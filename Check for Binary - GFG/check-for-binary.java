//{ Driver Code Starts
import java.util.*;


class checkBinary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			boolean b = g.isBinary(str);
			if(b== true)
				System.out.println(1);
			else
			    System.out.println(0);
		T--;
		}
	}
}


// } Driver Code Ends


class GfG
{
	boolean isBinary(String str)
	{
	  //Your code here
	  for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // Check if the character is not '0' or '1'
            if (c != '0' && c != '1') {
                return false; // Not a binary sequence
            }
        }
        
        return true; // It's a binary sequence
	}
}