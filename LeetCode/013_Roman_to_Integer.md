## 13. Roman to Integer
> For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II... [link](https://leetcode.com/problems/roman-to-integer/)
```
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```
```java
class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        Map<Character, Integer> romanNums = getRomanNums();
        
        for (int i = 0; i < s.length(); i++) {
            // 1 + 5 - 2 = 4 -> IV
            if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    answer -= 2;
                }
            }
            // 10 + 50 - 20 = 40 -> XL
            if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    answer -= 20;
                }
            }
            if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    answer -= 200;
                }
            }
            answer += romanNums.get(s.charAt(i));
        }
        return answer;
    }
    
    private Map<Character, Integer> getRomanNums() {
        Map<Character, Integer> romanNums = new HashMap<>();
        romanNums.put('I', 1);
        romanNums.put('V', 5);
        romanNums.put('X', 10);
        romanNums.put('L', 50);
        romanNums.put('C', 100);
        romanNums.put('D', 500);
        romanNums.put('M', 1000);
        return romanNums;
    }
}
```