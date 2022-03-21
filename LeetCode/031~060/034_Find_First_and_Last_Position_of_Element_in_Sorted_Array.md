## 34. Find First and Last Position of Element in Sorted Array
> Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If target is not found in the array, return [-1, -1]. [link](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[]{-1, -1};
        
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target) {
                answer[0] = (answer[0] == -1) ? start : Math.min(answer[0], start);
                answer[1] = (answer[1] == -1) ? start : Math.max(answer[1], start);
            }
            if (nums[end] == target) {
                answer[0] = (answer[0] == -1) ? end : Math.min(answer[0], end);
                answer[1] = (answer[1] == -1) ? end : Math.max(answer[1], end);
            }
            start++;
            end--;
        }
        return answer;
    }
}
```