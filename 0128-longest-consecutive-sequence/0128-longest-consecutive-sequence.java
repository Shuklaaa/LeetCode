class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        
        int longest = 1;
        
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i] - 1)){
                int currentNum = nums[i];
                int currentStreak = 1;
                
                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longest = Math.max(currentStreak, longest);
            }
        }
        return longest;
    }
}