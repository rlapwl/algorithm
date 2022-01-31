## 3. Longest Substring Without Repeating Characters
> Given a string s, find the length of the longest substring without repeating characters. [link](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        String subString = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = subString.indexOf(c);
            if (idx != -1) {
                maxLen = Math.max(maxLen, subString.length());
                start = idx + start + 1;
                subString = s.substring(start, i + 1);
            } else {
                subString += c;
            }
        }
        maxLen = Math.max(maxLen, subString.length());
        return maxLen;
    }
}
```