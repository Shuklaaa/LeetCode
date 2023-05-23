class Solution {
    public boolean isThree(int n) {
        int div = 2;   //1 and n are already divisors of n
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                div++;
            }
            if(div > 3){
                return false;
            }
        }
        return div == 3;
    }
}
