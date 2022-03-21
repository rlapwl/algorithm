## 75. Sort Colors
> Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. [link](https://leetcode.com/problems/sort-colors/)
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
```java
class Solution {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    
    private void sort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            sort(nums, start, pivot - 1);
            sort(nums, pivot, end);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[(start + end) / 2];
        
        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            
            while (pivot < nums[end]) {
                end--;
            }
            
            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                
                start++;
                end--;
            }
        }
        return start;
    }
}
```