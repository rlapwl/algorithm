## 136. Single Number
> Given a non-empty array of integers nums, every element appears twice except for one. Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space. [link](https://leetcode.com/problems/single-number/)
```
Input: nums = [4,1,2,1,2]
Output: 4
```
```java
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int answer = 0;
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            answer = itr.next();
        }
        return answer;
    }
}
```