class MinAvgTwoSlice {
    // O(n)
    public int solution(int[] A) {
        float min = (A[0] + A[1]) / 2f;
        int minIdx = 0;
        for (int i = 0; i < A.length - 1; i++) {
            float compareMin = min;
            if (i <= A.length - 3) {
                float avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3f;
                compareMin = Math.min(compareMin, avg3);
            }
            float avg2 = (A[i] + A[i + 1]) / 2f;
            compareMin = Math.min(compareMin, avg2);

            if (min > compareMin) {
                min = compareMin;
                minIdx = i;
            }
        }
        return minIdx;
    }
}