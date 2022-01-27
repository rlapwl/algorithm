## 70. Climbing Stairs
> You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? [link](https://leetcode.com/problems/climbing-stairs/)
```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```
```java
class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        if (n >= 2) {
            stairs[2] = 2;
        }
        
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 2] + stairs[i - 1];
        }
        return stairs[n];
    }
}
```