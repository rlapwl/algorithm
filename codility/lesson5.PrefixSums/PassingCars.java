class PassingCars {
    // O(N)
    public int solution(int[] A) {
        int result = 0;
        int sum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                result += sum;
                if (result > 1000000000) {
                    return -1;
                }
                continue;
            }
            sum += 1;
        }
        return result;
    }
}