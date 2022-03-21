## 01. Two Sum
> Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice. **Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?** [link](https://leetcode.com/problems/two-sum/)
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int subNum = target - nums[i];
            if (numbers.get(subNum) != null) {
                int j = numbers.get(subNum);
                return new int[]{j, i};
            }
            numbers.put(nums[i], i);
        }
        
        return new int[]{};
    }
}
```

