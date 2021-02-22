import java.util.*;

class Nesting {
    // O(n)
    public int solution(String S) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                brackets.push(c);
            } else if (c == ')') {
                if (brackets.isEmpty()) {
                    return 0;
                }
                
                brackets.pop();
            }
        }
        if (brackets.isEmpty()) {
            return 1;
        }
        return 0;
    }
}