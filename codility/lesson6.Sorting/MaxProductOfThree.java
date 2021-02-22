import java.util.*;

class MaxProductOfThree {
    // O(N * log(N))
    public int solution(int[] A) {
        int end = A.length;
        Arrays.sort(A);

        if (A[end - 1] < 0) {
            return A[end - 3] * A[end - 2] * A[end - 1];
        }
        return Math.max((A[0] * A[1]), (A[end - 2] * A[end -3])) * A[end -1];
    }
}