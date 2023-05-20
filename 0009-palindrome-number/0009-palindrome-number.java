class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int n = x;
        int ans = 0;
        while(n != 0){
            ans = (ans * 10) + (n % 10);
            n /= 10;
        }
        if(x == ans){
            return true;
        }
        return false;
    }
}