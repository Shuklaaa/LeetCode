class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(!hs.add(nums[i])){
                ans = nums[i];
            }
        }
        return ans;
    }
}