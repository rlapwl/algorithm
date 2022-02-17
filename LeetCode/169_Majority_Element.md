## 169. Majority Element
> Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array. [link](https://leetcode.com/problems/majority-element/)
```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```
```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int targetCnt = nums.length / 2;
        int beforeNum = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == beforeNum) {
                count++;
                continue;
            }
            if (count > targetCnt) {
                return beforeNum;
            }
            count = 1;
            beforeNum = nums[i];
        }
        return beforeNum;
    }
}
```