class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] exp = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++){
            exp[i] = heights[i];
        }
        
        Arrays.sort(heights);
        for(int i = 0; i < heights.length; i++){
            if(exp[i] != heights[i]){
                count++;
            }
        }
        return count;
    }
}

