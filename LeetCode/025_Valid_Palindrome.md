## 25. Valid Palindrome
> A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. [link](https://leetcode.com/problems/valid-palindrome/)
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```
```java
class Solution {
    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        Deque<Character> queue = new LinkedList<>();
        
        for (char c : array) {
            queue.add(c);
        }
        
        while (!queue.isEmpty()) {
            char left = queue.peek();
            char right = queue.peekLast();
            if (left != right) {
                return false;
            }
            queue.poll();
            queue.pollLast();
        }
        return true;
    }
}
```