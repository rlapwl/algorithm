## 322. Coin Change
> You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. [link](https://leetcode.com/problems/coin-change/)
```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int cIdx = 0; cIdx < coins.length; cIdx++) {
                if (coins[cIdx] > i) {
                    continue;
                }

                if  (dp[i - coins[cIdx]] < 0) {
                    continue;
                }

                if (dp[i] < 0 || dp[i - coins[cIdx]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[cIdx]] + 1;
                }
            }
        }
        return dp[amount];
    }
}
```