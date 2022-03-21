## 36. Valid Sudoku
> Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules.. [link](https://leetcode.com/problems/valid-sudoku/)
```
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character> nums = new HashSet<>();
        
        // 가로 탐색
        for (int i = 0; i < 9; i++) {
            nums = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if ('.' == num) {
                    continue;
                }
                if (nums.contains(num)) {
                    return false;
                }
                nums.add(num);
            }
        }
        
        // 세로 탐색
        for (int i = 0; i < 9; i++) {
            nums = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char num = board[j][i];
                if ('.' == num) {
                    continue;
                }
                if (nums.contains(num)) {
                    return false;
                }
                nums.add(num);
            }
        }
        
        int rowIdx = 3;
        int colIdx = 3;
        // 3*3 탐색
        while (rowIdx <= 9 && colIdx <= 9) {
            nums = new HashSet<>();
            
            for (int i = rowIdx - 3; i < rowIdx; i++) {
                for (int j = colIdx - 3; j < colIdx; j++) {
                    char num = board[i][j];
                    if ('.' == num) {
                        continue;
                    }
                    if (nums.contains(num)) {
                        return false;
                    }
                    nums.add(num);
                }
            }
            
            if (colIdx < 9) {
                colIdx += 3;
            } else {
                rowIdx += 3;
                colIdx = 3;
            }
        }
        return true;
    }
}
```