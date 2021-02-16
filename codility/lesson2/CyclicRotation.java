class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int idx = (i + K) % length;
            result[idx] = A[i];
        }
        return result;
    }
}