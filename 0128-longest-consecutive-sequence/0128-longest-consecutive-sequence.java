class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1){
            return n;
        }
        
        Arrays.sort(nums);
        
        int max =Integer.MIN_VALUE, count = 1;
        
        for(int i = 0; i < n - 1; i++){
            if(nums[i + 1] - nums[i] == 1){
                count++;
            }
            else{
                count = nums[i + 1] == nums[i] ? count : 1;
            }
            
            max = Math.max(count, max);
            
        }
        return max;
    }
}

