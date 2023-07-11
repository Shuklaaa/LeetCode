class Solution {
    public int findComplement(int num) {
        int bitL = (int)(Math.log(num) / Math.log(2));
        
        bitL = bitL + 1;
        
        int bitM = (1 << (bitL)) - 1;
        
        return bitM ^ num;
    }
}