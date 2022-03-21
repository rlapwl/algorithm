## 5. Longest Palindromic Substring
> Given a string s, return the longest palindromic substring in s. [link](https://leetcode.com/problems/longest-palindromic-substring/)
```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```
```java
class Solution {
    private int startIdx = 0;
    private int maxLength = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        
        for (int i = 0; i < s.length(); i++) {
            around(s, i, i);
            around(s, i, i + 1);
        }
        return s.substring(startIdx, startIdx + maxLength);
    }
    
    private void around(String s, int start, int end) {
        while (0 <= start && end < s.length() &&
              s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (maxLength < (end - start - 1)) {
            maxLength = (end - start - 1);
            startIdx = start + 1;
        }
    }
}
```