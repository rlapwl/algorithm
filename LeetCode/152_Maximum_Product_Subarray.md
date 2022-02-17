## 152. Maximum Product Subarray
> Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product. The test cases are generated so that the answer will fit in a 32-bit integer. A subarray is a contiguous subsequence of the array. [link](https://leetcode.com/problems/maximum-product-subarray/)
```
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```
```java
class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int beforeMax = nums[0];
        int beforeMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int x = Math.max(nums[i], Math.max(beforeMax * nums[i], beforeMin * nums[i]));
            int y = Math.min(nums[i], Math.min(beforeMax * nums[i], beforeMin * nums[i]));
            beforeMax = x;
            beforeMin = y;
            answer = Math.max(beforeMax, answer);
        }
        return answer;
    }
}
```