## 7. Reverse Integer
> Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0. [link](https://leetcode.com/problems/reverse-integer/)
```
Input: x = -123
Output: -321

Input: x = 120
Output: 21
```
```java
class Solution {
    public int reverse(int x) {
        long answer = 0;
        
        while (x != 0) {
            answer = (answer * 10) + (x % 10);
            x = x / 10;
            
            if (answer <= Integer.MIN_VALUE || Integer.MAX_VALUE <= answer) {
                return 0;
            }
        }
        return (int) answer;
    }
}
```