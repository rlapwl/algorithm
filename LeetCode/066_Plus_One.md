## 66. Plus One
> You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's... [link](https://leetcode.com/problems/plus-one/)
```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
```
#### Solution 1
```java
class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i];
            if (i == digits.length - 1) {
                sum += 1;
            }
            
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            stack.push(sum);
        }
        
        if (carry > 0) {
            stack.push(carry);
        }
        
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
```
#### Solution 2
```java
class Solution {
    public int[] plusOne(int[] digits) {
        
        for (int i = digits.length - 1; i >= 0; i--) {
            // 9보다 작은 수일 경우 1을 더하면 자릿수가 +1 되지 않으므로 바로 끝내버린다.
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }
}
```