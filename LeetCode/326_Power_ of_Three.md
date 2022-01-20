## 326. Power of Three
> Given an integer n, return true if it is a power of three. Otherwise, return false. An integer n is a power of three, if there exists an integer x such that n == 3x. [link](https://leetcode.com/problems/power-of-three/)
```
Input: n = 27
Output: true

Input: n = 0
Output: false
```
#### Solution 1
```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int startIdx = 0;
        while (true) {
            double num = Math.pow(3, startIdx++);
            if (num >= n) {
                return num == n;
            }
        }
    }
}
```
#### Solution 2
- Solution_1 보다 더 빠르다.
```java
/*
 * -2^31 <= n <= 2^31 - 1 이므로
 * 3^19 = 1162261467 -> int 범위에서 최대값.
 * 3^20 = 3486784401 -> long 타입
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        // n이 음수값일 경우도 있으므로
        if (n <= 0) {
            return false;
        }
        return 1162261467 % n == 0;
    }
}
```
#### 참고
- 아래와 같은 방법도 생각했으나 n이 3의 거듭제곱이어도 ``Math.log(n) / Math.log(3)`` 계산시 완전히 정수값을 return하지 못한다. 그래서 아래 방법은 실패.
```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        double num = Math.log(n) / Math.log(3);
        return (num - Math.floor(num)) == 0;
    }
}
```