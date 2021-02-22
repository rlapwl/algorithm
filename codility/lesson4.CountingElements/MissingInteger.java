import java.util.*;

class MissingInteger {
    // O(N) or O(N * log(N))
    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }

        int num = 1;
        while (numbers.contains(num)) {
            num++;
        }
        return num;
    }
}