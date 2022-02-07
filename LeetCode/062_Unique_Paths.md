## 62. Unique Paths
> There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time. [link](https://leetcode.com/problems/unique-paths/)
```
Input: m = 3, n = 7
Output: 28
```
```java
class Solution {
    public int uniquePaths(int m, int n) {
        return movePath(m, n, 0, 0);
    }
    
    private int movePath(int m, int n, int x, int y) {
        if (x == (m - 1) && y == (n - 1)) {
            return 1;
        }
        
        if (x == m || y == n) {
            return 0;
        }
        
        int count = 0;
        count += movePath(m, n, x + 1, y);
        count += movePath(m, n, x, y + 1);
        return count;
    }
}
```