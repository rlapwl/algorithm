## 204. Count Primes
> Given an integer n, return the number of prime numbers that are strictly less than n. [link](https://leetcode.com/problems/count-primes/)
```
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```
```java
class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrime[j]) {
                    count--;
                    isPrime[j] = true;   
                }
            }
        }
        return count;
    }
}
```