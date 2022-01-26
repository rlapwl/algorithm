## 20. Valid Parentheses
> Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid... [link](https://leetcode.com/problems/valid-parentheses/)
```
Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false
```
```java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> matches = new HashMap<>();
        matches.put('(', ')');
        matches.put('[', ']');
        matches.put('{', '}');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            if (matches.containsKey(parentheses)) {
                stack.push(parentheses);
                continue;
            }
            if (!stack.isEmpty()) {
                char target = matches.get(stack.peek());
                if (parentheses == target) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
```

