class CountDiv {
    public int solution(int A, int B, int K) {
        int startIdx = (A / K);
        int endIdx = (B / K);
        if ((A % K) == 0) {
            startIdx -= 1;
        }
        return endIdx - startIdx;
    }
}