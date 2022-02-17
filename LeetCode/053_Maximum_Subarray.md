## 53. Maximum Subarray
> Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. A subarray is a contiguous part of an array. [link](https://leetcode.com/problems/maximum-subarray/)
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            answer = Math.max(nums[i], answer);
        }
        return answer;
    }
}
```