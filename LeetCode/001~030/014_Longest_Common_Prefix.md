## 14. Longest Common Prefix
> Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "". [link](https://leetcode.com/problems/longest-common-prefix/)
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```
#### Solution 1
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
                minStr = str;
            }
        }
        
        for (int i = minLength; i > 0; i--) {
            String prefix = minStr.substring(0, i);
            int cnt = 0;
            for (String str : strs) {
                if (prefix.equals(str.substring(0, i))) {
                    cnt++;
                }
            }
            if (cnt == strs.length) {
                return prefix;
            }
        }
        return "";
    }
}
```

#### Solution 2
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```