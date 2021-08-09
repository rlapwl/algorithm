import java.util.*;

// [17] Letter-Combinations-Of-A-Phone-Number
public class LetterCombinationsOfAPhoneNumber {
    
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
