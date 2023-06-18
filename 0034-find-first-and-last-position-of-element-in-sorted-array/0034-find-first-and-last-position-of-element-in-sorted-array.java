class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStart(nums, target);
        res[1] = findEnd(nums, target);

        return res;
    }

    public int findStart(int[] nums, int target){
        int s = 0, e = nums.length - 1;
        int idx = -1;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(nums[m] == target){
            idx = m;
            }
            
            if(nums[m] >= target){
            e = m - 1;
            }
            else{
            s = m + 1;
            }
            
        }
        return idx;
    }

    public int findEnd(int[] nums, int target){
        int s = 0, e = nums.length - 1;
        int idx = -1;

        while(s <= e){
            int m = s + (e - s) / 2;
            if(nums[m] == target){
            idx = m;
            }

            if(nums[m] <= target){
            s = m + 1;
            }
            else{
            e = m - 1;
            }
        }
        return idx;
    }
}