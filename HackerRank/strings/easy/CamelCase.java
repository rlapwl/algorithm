public class CamelCase {
    static int solution(String s) {
        int result = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                result++;
            }
        }
        return result;
    }
}