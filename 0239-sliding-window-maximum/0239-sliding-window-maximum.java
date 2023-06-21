class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n - k + 1];
        
        int rightIdx = 0;
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i = 0; i < n; i++){
//             removing numbers out of range k
            if(!dq.isEmpty() && dq.peek() == i - k){
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i >= k - 1){
                r[rightIdx++] = nums[dq.peek()];
            }
        }
        return r;
    }
}