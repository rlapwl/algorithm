import java.util.*;

class AbsDistinct {
    // O(N) or O(N*log(N))
    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                numbers.add(A[i] * -1);
                continue;
            }
            numbers.add(A[i]);
        }
        return numbers.size();
    }
}