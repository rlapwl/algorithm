## 43. Multiply Strings
> Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string. [link](https://leetcode.com/problems/multiply-strings/)
```
Input: num1 = "123", num2 = "456"
Output: "56088"
```
```java
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        
        int[] ans = new int[num1.length() + num2.length()];
        int idx = num1.length() + num2.length() - 1;
        for (int i = num2.length() - 1 ; i >= 0; i--) {
            int carry = 0;
            int x = idx;
            for (int j = num1.length() - 1; j >= 0 ; j--) {
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry + ans[x];
                carry = mul / 10;
                mul = mul % 10;
                
                ans[x--] = mul;
            }
            if (carry > 0) {
                ans[x] += carry;
            }
            idx--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0 && answer.isEmpty()) {
                continue;
            }
            answer.append(ans[i]);
        }
        return answer.toString();
    }
}
```