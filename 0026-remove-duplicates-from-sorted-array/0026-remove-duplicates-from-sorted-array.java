class Solution {
    public int removeDuplicates(int[] A) {
        int N = A.length;
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[N];
        int index = 0;
        
        for (int i = 0; i < N; i++) {
            if (!set.contains(A[i])) {
                set.add(A[i]);
                A[index] = A[i];
                index++;
            }
        }
        
        return index;
    }
}

