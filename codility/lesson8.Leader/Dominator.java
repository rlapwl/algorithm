import java.util.*;

class Dominator {
    // O(N*log(N)) or O(N)
    // Dominator은 발생빈도가 A의 절반을 초과해야함.
    public int solution(int[] A) {
        Map<Integer, Integer> countOfElements = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            countOfElements.put(A[i], countOfElements.getOrDefault(A[i], 0) + 1);
        }

        int mid = A.length / 2;
        int maxCount = 0;
        for (Integer element : countOfElements.keySet()) {
            int countOfElement = countOfElements.get(element);
            if (countOfElement > mid && maxCount < countOfElement) {
                maxCount = countOfElement;
            }
        }
        if (maxCount <= mid) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (countOfElements.get(A[i]) == maxCount) {
                return i;
            }
        }
        return -1;
    }
}
