## 1392. Longest Happy Prefix
> A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself). Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists. [link](https://leetcode.com/problems/longest-happy-prefix/)
```
Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
```
```java
class Solution {
    public String longestPrefix(String s) {
        
        int[] check = new int[s.length()];
        char[] sChars = s.toCharArray();
        int prefixIdx = 0;
        
        for (int suffixIdx = 1; suffixIdx < s.length(); suffixIdx++) {
            while (prefixIdx > 0 && sChars[prefixIdx] != sChars[suffixIdx]) {
                prefixIdx = check[prefixIdx - 1];
            }
            
            if (sChars[prefixIdx] == sChars[suffixIdx]) {
                check[suffixIdx] = ++prefixIdx;
            }
        }
        
        int startIdx = s.length() - check[s.length() - 1];
        if (startIdx == s.length()) {
            return "";
        }
        return s.substring(startIdx);
    }
}
```