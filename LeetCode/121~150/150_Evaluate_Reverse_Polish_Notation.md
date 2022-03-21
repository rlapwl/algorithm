## 150. Evaluate Reverse Polish Notation
> Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, and /. Each operand may be an integer or another expression. [link](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
```
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                stack.push(calculate(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));   
            }
        }
        return stack.pop();
    }
    private int calculate(String op, int n1, int n2) {
        if ("+".equals(op)) {
            return n2 + n1;
        } else if ("-".equals(op)) {
            return n2 - n1;
        } else if ("*".equals(op)) {
            return n2 * n1;
        } else {
            return n2 / n1;
        }
    }
}
```