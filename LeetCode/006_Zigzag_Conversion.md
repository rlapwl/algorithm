## 6. Zigzag Conversion
> The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:.. [link](https://leetcode.com/problems/zigzag-conversion/)
```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```
```java
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        
        int mod = (int) Math.ceil((s.length() - numRows) / (2.0 * numRows - 2));
        int col = mod * (numRows - 1) + 1;
        char[][] zigzag = new char[numRows][col];
        
        int x = 0;
        int y = 0;
        boolean isDown = true;
        for (int i = 0; i < s.length(); i++) {
            zigzag[x][y] = s.charAt(i);
            
            if (isDown) {
                x++;
                if (x == numRows) {
                    x -= 2;
                    y += 1;
                    if (x > 0) {
                        isDown = false;   
                    }
                }
            } else {
                x--;
                y++;
                if (x == 0) {
                    isDown = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (zigzag[i][j] == 0) {
                    continue;
                }
                sb.append(zigzag[i][j]);
            }
        }
        return sb.toString();
    }
}
```