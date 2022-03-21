## 9. Palindrome Number
> Given an integer x, return true if x is palindrome integer. An integer is a palindrome when it reads the same backward as forward. Could you solve it without converting the integer to a string? [link](https://leetcode.com/problems/palindrome-number/)
```
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
```
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }
}
```