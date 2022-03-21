## 33. Search in Rotated Sorted Array
> There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed)... You must write an algorithm with O(log n) runtime complexity. [link](https://leetcode.com/problems/search-in-rotated-sorted-array/)
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (nums[mid] == target) {
				return mid;
			}
            
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }   
            }
		}
		return -1;
    }
}
```