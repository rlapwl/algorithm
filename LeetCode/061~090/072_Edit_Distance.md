## 72. Edit Distance
> Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2. [link](https://leetcode.com/problems/edit-distance/)
```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```
```java
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j] => word1의 i번째까지와 word2의 j번째까지 바꾸는 최소 횟수
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        
        return dp[len1][len2];
    }
}
```