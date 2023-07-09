//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0 && arr[i] <= size) {
                int num = arr[i];
                int index = num - 1;

                // Check if the number is already marked as present
                if (arr[index] != num) {
                    swap(arr, i, index);
                    i--; // Revisit the current index
                }
            }
        }

        // Find the smallest missing positive number
        for (int i = 0; i < size; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return size + 1; // All numbers from 1 to size are present
    }

    // Function to swap elements in the array.
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends