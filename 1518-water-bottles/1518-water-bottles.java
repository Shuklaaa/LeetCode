class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        
        while(numBottles >= numExchange){
            sum += numBottles / numExchange;
            int temp = numBottles % numExchange;
            
            numBottles = numBottles / numExchange;
            numBottles += temp;
        }
        
        return sum;
    }
}