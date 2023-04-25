class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int idx = nums[i] % n;
            nums[idx] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] / n >= 2){
                ans = i;
            }
        }
        return ans;
    }
}