class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }

            start++;
            end--;
        }
        return -1;
    }
}