## 17. Letter Combinations of a Phone Number
> Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order. A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. [link](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```
```java
class Solution {
    public static final List<String> letters = Arrays.asList(new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"});
    public final List<String> answers = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return answers;
        }
        combination("", digits, 0);
        return answers;
    }
    
    private void combination(String prefix, String digits, int now) {
        if (prefix.length() == digits.length()) {
            answers.add(prefix);
            return;
        }
        
        int index = digits.charAt(now) - '0';
        String letter = letters.get(index - 2);
        for (int i = 0; i < letter.length(); i++) {
            combination(prefix + letter.charAt(i), digits, now + 1);
        }
    }
}
```