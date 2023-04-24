class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, hi = nums.length - 1;
        while(m <= hi){
            if(nums[m] == 0){
                swap(nums, l, m);
                l++;
                m++;
            }

            else if(nums[m] == 1){
                m++;
            }

            else if(nums[m] == 2){
                swap(nums, m, hi);
                hi--;
            }
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}