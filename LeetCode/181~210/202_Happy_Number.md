## 202. Happy Number
> Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process: Starting with any positive integer... Return true if n is a happy number, and false if not. [link](https://leetcode.com/problems/happy-number/)
```
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```
```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<>();
		while (!cache.contains(n)) {
			cache.add(n);
			n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
```