class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(ans, 0, new ArrayList<Integer>(), nums);
        
        return ans;
    }
    
    public void bt(List<List<Integer>> ans, int start, List<Integer> track, int[] nums){
        ans.add(new ArrayList<Integer>(track));
        
        for(int i = start; i < nums.length; i++){
            track.add(nums[i]);
            bt(ans, i + 1, track, nums);
            track.remove(track.size() - 1);
        }
    }
}