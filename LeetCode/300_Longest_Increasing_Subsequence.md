## 300. Longest Increasing Subsequence
> Given an integer array nums, return the length of the longest strictly increasing subsequence. A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. [link](https://leetcode.com/problems/longest-increasing-subsequence/)
```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int j = 0;
		int[] arr = new int[nums.length];
		arr[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (arr[j] < nums[i]) {
                arr[++j] = nums[i];
                continue;
            }
            int idx = getInputIdx(arr, j, nums[i]);
            arr[idx] = nums[i];
        }
        return j + 1;
    }
    private int getInputIdx(int[] arr, int lastIdx, int num) {
        int left = 0;
        int right = lastIdx;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
```