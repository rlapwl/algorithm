## 69. Sqrt(x)
> Given a non-negative integer x, compute and return the square root of x. Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned. [link](https://leetcode.com/problems/sqrtx/)
```
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
```
```java
class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}
```