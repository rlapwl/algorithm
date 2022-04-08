## 64. Minimum Path Sum
> Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path. You can only move either down or right at any point in time. [link](https://leetcode.com/problems/minimum-path-sum/)
```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
```
```java
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
}
```