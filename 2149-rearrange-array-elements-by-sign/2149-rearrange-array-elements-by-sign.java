class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] neg = new int[n / 2];
        int[] pos = new int[n / 2];
        
        int idxN = 0;
        int idxP = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                neg[idxN] = nums[i];
                idxN++;
            }
            else{
                pos[idxP] = nums[i];
                idxP++;
            }
        }
        
        idxN = 0;
        idxP = 0;
        for(int i = 0; i < n; i = i + 2){
            nums[i] = pos[idxP];
            idxP++;
        }
        for(int i = 1; i < n; i = i + 2){
            nums[i] = neg[idxN];
            idxN++;
        }
        
        return nums;
    }
}