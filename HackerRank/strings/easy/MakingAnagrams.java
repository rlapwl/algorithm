public class MakingAnagrams {
    static int solution(String s1, String s2) {
        int[] c = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            c[s2.charAt(i) - 'a']--;
        }

        int result = 0;
        for (int num : c) {
            result += Math.abs(num);
        }
        return result;
    }
}