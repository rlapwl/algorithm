## 338. Counting Bits
> Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. [link](https://leetcode.com/problems/counting-bits/)
```
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```
```java
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int mod = i / 2;
            
            if ((i % 2) == 0) {
                // 짝수는 LSB가 0이다. 4 -> 100 6 -> 110
                ans[i] = ans[mod];
            } else {
                // 홀수는 LSB가 1이다. 5 -> 101 25 -> 11001
                ans[i] = ans[mod] + 1;
            }
        }
        return ans;
    }
}
```