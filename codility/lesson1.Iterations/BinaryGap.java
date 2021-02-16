class BinaryGap {
    public int solution(int N) {
        int max = 0;
        
        String binaryNumber = Integer.toBinaryString(N);
        int firstIdx = binaryNumber.indexOf("1");
        if (firstIdx == -1) {
            return max;
        }
        
        while (binaryNumber.indexOf("1", firstIdx + 1) != -1) {
            int secondIdx = binaryNumber.indexOf("1", firstIdx + 1);
            int gap = secondIdx - firstIdx - 1;
            if (gap > max) {
                max = gap;
            }
            firstIdx = secondIdx;
        }
        return max;
    }
}