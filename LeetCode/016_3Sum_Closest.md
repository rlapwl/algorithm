## 16. 3Sum Closest
> Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target. [link](https://leetcode.com/problems/3sum-closest/)
```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = Integer.MAX_VALUE - 3000;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum == target) {
                    return target;
                }
                
                if (Math.abs(target - sum) < Math.abs(target - answer)) {
                    answer = sum;
                }
                
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return answer;
    }
}
```