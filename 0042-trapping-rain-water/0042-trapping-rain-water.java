class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        int lmax = 0, rmax = 0;
        
        while(l <= r){
            if(height[l] <= height[r]){
                
                if(height[l] >= lmax){
                    lmax = height[l];
                }
                else{
                    ans += lmax - height[l];
                }
                l++;
            }
            else{
                if(height[r] >= rmax){
                    rmax = height[r];
                }
                else{
                    ans += rmax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}