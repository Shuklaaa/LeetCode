class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int n : nums1){
            set1.add(n);
        }
        for(int n : nums2){
            set2.add(n);
        }
        
        set1.retainAll(set2);
        
        int[] ans = new int[set1.size()];
        
        
        int idx = 0;
        
        for(int ele:set1){
            ans[idx++] = ele;
        }
        return ans;
    }
}