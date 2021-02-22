class MaxSliceSum {
    // O(n)
    private int getMaxSumOfSlice(int[] A) {
        int max = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(A[i], sum + A[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
    public int solution(int[] A) {
        return getMaxSumOfSlice(A);
    }
}