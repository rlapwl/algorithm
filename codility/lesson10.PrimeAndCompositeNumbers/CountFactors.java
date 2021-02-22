class CountFactors {
    // O(sqrt(N))
    public int solution(int N) {
        int result = 0;
        int mid = (int) Math.sqrt(N);
        for (int d = 1; d <= mid; d++) {
            if (N % d != 0) {
                continue;
            }
            if (Math.pow(d, 2) == N) {
                result += 1;
            } else {
                result += 2;
            }
        }
        return result;
    }
}