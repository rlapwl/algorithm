import java.util.*;

// Solution1
class OddOccurrencesInArray1 {
     // O(N) or O(N*log(N))
    public int solution(int[] A) {
        int answer = 0;
        Map<Integer, Integer> oddNumbers = new HashMap<>();

        for (int idx = 0; idx < A.length; idx++) {
            if (oddNumbers.get(A[idx]) == null) {
                oddNumbers.put(A[idx], 1);
                continue;
            }
            oddNumbers.put(A[idx], oddNumbers.get(A[idx]) + 1);
        }

        for (int idx = 0; idx < A.length; idx++) {
            if (oddNumbers.get(A[idx]) % 2 != 0) {
                answer = A[idx];
                break;
            }
        }
        return answer;
    }
}