## 79. Word Search
> Given an m x n grid of characters board and a string word, return true if word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once. [link](https://leetcode.com/problems/word-search/)
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```
```java
class Solution {
    private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(int i, int j, int idx, char[][] board, String word) {
        
        if (idx == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (word.charAt(idx) != board[i][j] || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        if (searchWord(i - 1, j, idx + 1, board, word) ||
           searchWord(i + 1, j, idx + 1, board, word) ||
           searchWord(i, j - 1, idx + 1, board, word) ||
           searchWord(i, j + 1, idx + 1, board, word)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
```