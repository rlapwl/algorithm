## 62. Unique Paths
> There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time. [link](https://leetcode.com/problems/unique-paths/)
```
Input: m = 3, n = 7
Output: 28
```
```java
class Solution {
    private int[][] paths;
    public int uniquePaths(int m, int n) {
        paths = new int[m][n];
        movePath(m, n);
        return paths[m - 1][n - 1];
    }
    
    private void movePath(int m, int n) {
        for (int y = 0; y < n; y++) {
            paths[0][y] = 1;
        }
        
        for (int x = 1; x < m; x++) {
            paths[x][0] = 1;
            for (int y = 1; y < n; y++) {
                paths[x][y] = paths[x - 1][y] + paths[x][y - 1];
            }
        }
    }
}
```