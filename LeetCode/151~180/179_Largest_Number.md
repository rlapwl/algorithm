## 179. Largest Number
> Given a list of non-negative integers nums, arrange them such that they form the largest number and return it. [link](https://leetcode.com/problems/largest-number/)
```
Input: nums = [3,30,34,5,9]
Output: "9534330"
```
```java
class Solution {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(sNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String o1 = s1 + s2;
                String o2 = s2 + s1;
                return o2.compareTo(o1);
            }
        });
        
        if ("0".equals(sNums[0])) {
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (String num : sNums) {
            answer.append(num);
        }
        return answer.toString();
    }
}
```