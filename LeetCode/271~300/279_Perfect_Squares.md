## 279. Perfect Squares
> Given an integer n, return the least number of perfect square numbers that sum to n. A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not. [link](https://leetcode.com/problems/perfect-squares/)
```
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
```
```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for (int  i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            int j = 1;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }
}
```