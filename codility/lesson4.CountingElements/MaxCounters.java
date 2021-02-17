import java.util.*;

class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];

        int max = 0;
        int globalMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (isMaxCounter(A[i], N)) {
                globalMax = max;
                continue;
            }

            int idx = A[i] - 1;
            counters[idx] += 1;
            if (counters[idx] <= globalMax) {
                counters[idx] = globalMax + 1;
            }
            if (max < counters[idx]) {
                max = counters[idx];
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < globalMax) {
                counters[i] = globalMax;
            }
        }
        return counters;
    }

    private boolean isMaxCounter(int element, int n) {
        if (element == n + 1) {
            return true;
        }
        return false;
    }
}