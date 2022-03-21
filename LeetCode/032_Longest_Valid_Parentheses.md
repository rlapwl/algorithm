## 32. Longest Valid Parentheses
> Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. [link](https://leetcode.com/problems/longest-valid-parentheses/)
```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
```
```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {  
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            
            stack.pop();
            
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                answer = Math.max(answer, i - stack.peek());
            }
        }
        return answer;
    }
}
```