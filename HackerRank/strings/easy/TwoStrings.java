public class TwoStrings {
    static String solution(String s1, String s2) {
        Set<Character> s1Chars = new HashSet<>();
        Set<Character> s2Chars = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Chars.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            s2Chars.add(s2.charAt(i));
        }
        
        s1Chars.retainAll(s2Chars);
        if (!s1Chars.isEmpty()) {
            return "YES";
        }
        return "NO";
    }