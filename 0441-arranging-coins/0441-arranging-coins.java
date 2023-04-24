class Solution {
    public int arrangeCoins(int n) {
        long s = 0, e = n;
        while(s <= e){
            long m = s + (e - s) / 2;
            long k = m * (m + 1) / 2;
            
            if(k == n){
                return (int)m;
            }
            
            else if(k > n){
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return (int)e;
    }
}