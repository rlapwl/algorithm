## 96. Unique Binary Search Trees
> Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n. [link](https://leetcode.com/problems/unique-binary-search-trees/)
```
Input: n = 3
Output: 5
```
```java
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // j = root
        // j - 1: 왼쪽 서브트리의 경우의 수
        // ㅑ - ㅓ: 오른쪽 서브트리의 경우의 수
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
```