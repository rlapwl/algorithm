import java.util.*;

class Distinct {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            elements.add(A[i]);
        }
        return elements.size();
    }
}