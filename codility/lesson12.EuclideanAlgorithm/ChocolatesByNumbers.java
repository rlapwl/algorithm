
class ChocolatesByNumbers {
    // O(log(N + M))
    public int solution(int N, int M) {
        int num = N;
        while (N % M != 0) {
            int temp = N;
            N = M;
            M = temp % M;
        }
        if (M == 1) {
            return num;
        }
        return num / M;
    }
}