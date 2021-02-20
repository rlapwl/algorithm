class FrogJmp {
    // O(1)
    public int solution(int X, int Y, int D) {
        int subDistance = Y - X;
        int result = subDistance / D;
        if (subDistance % D != 0) {
            result += 1;
        }
        return result;
    }
}