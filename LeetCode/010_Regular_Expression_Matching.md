## 10. Regular Expression Matching
> Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where: The matching should cover the entire input string (not partial). [link](https://leetcode.com/problems/regular-expression-matching)
```
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```
```java
class Solution {
    private boolean[][] matches;
    
    public boolean isMatch(String s, String p) {
        matches = new boolean[s.length() + 1][p.length() + 1];
        matches[s.length()][p.length()] = true;
        
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                
                boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    matches[i][j] = matches[i][j + 2] || firstMatch && matches[i + 1][j];
                } else {
                    matches[i][j] = firstMatch && matches[i + 1][j + 1];
                }
            }
        }
        return matches[0][0];
    }
}
```