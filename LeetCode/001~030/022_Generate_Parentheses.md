## 22. Generate Parentheses
> Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. [link](https://leetcode.com/problems/generate-parentheses/)
```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```
```java
class Solution {
    private List<String> answer;
    
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        combination("(", n, 1, 0);
        return answer;
    }
    
    private void combination(String parenthesis, int n, int lCnt, int rCnt) {
        if (parenthesis.length() == n*2 && lCnt == rCnt) {
            String p = parenthesis;
            answer.add(p);
            return;
        }
        
        if (lCnt < n) {
            combination(parenthesis + '(', n, lCnt + 1, rCnt);
        }
        
        if (rCnt < lCnt) {
            combination(parenthesis + ')', n, lCnt, rCnt + 1);   
        }
    }
}
```