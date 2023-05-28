class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        
        int nIdx = 1, pIdx = 0; 
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                ans[nIdx] = nums[i];
                nIdx += 2;
            }
            
            else{
                ans[pIdx] = nums[i];
                pIdx += 2;
            }
        }
        return ans;
    }
}