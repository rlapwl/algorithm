## 242. Valid Anagram
> Given two strings s and t, return true if t is an anagram of s, and false otherwise. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. [link](https://leetcode.com/problems/valid-anagram/)
```
Input: s = "anagram", t = "nagaram"
Output: true
```
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] alpha = new int[26];
        for (char c : s.toCharArray()) {
            alpha[c -'a']++;
        }
        
        for (char c : t.toCharArray()) {
            int idx = c - 'a';
            if (alpha[idx] == 0) {
                return false;
            }
            alpha[idx]--;
        }
        return true;
    }
}
```