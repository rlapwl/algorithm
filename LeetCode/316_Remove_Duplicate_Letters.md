## 316. Remove Duplicate Letters
> Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results. [link](https://leetcode.com/problems/remove-duplicate-letters/)
```
Input: s = "cbacdcbc"
Output: "acdb"
```
```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        LinkedList<Character> tmp = new LinkedList<>();
        boolean[] isAdded = new boolean[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            
            if (isAdded[c - 'a']) {
                continue;
            }
            
            while (!tmp.isEmpty() && tmp.getLast() > c && freq[tmp.getLast() - 'a'] > 0) {
                isAdded[tmp.removeLast() - 'a'] = false;
            }
            
            tmp.add(c);
            isAdded[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!tmp.isEmpty()) {
            sb.append(tmp.removeFirst());
        }
        return sb.toString();
    }
}
```