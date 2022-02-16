## 371. Sum of Two Integers
> Given two integers a and b, return the sum of the two integers without using the operators + and -. [link](https://leetcode.com/problems/sum-of-two-integers/)
```
Input: a = 1, b = 2
Output: 3
```
```java
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
```