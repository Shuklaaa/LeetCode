class Solution {
    public int countDigits(int num) {
        int count = 0;
        int rem = 0;
        int cont = num;
        
        while(num > 0){
            if(cont % (num % 10) == 0){
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
