class FrogRiverOne {
    // O(n)
    public int solution(int X, int[] A) {
        boolean[] existA = new boolean[X + 1];
        int check = 0;
        for (int k = 0; k < A.length; k++) {
            if (A[k] <= X && !existA[A[k]]) {
                existA[A[k]] = true;
                check += 1;
                if (check == X) {
                    return k;
                }
            }
        }
        return -1;
    }
}