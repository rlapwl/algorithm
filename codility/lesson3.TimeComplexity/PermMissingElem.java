import java.util.*;

class PerMissingElem {
    // O(N) or O(N * log(N))
    public int solution(int[] A) {
        Map<Integer, Boolean> elements = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            elements.put(A[i], true);
        }

        for (int num = 1; num <= A.length + 1; num++) {
            if (elements.get(num) == null) {
                return num;
            }
        }
        return 0;
    }
}