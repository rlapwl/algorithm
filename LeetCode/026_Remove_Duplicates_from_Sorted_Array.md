## 26. Remove Duplicates from Sorted Array
> Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. [link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int answer = 0;
        int idx = 0;
        int beforeNum = -101;
        for (int i = 0; i < nums.length; i++) {
            if (beforeNum != nums[i]) {
                nums[idx++] = nums[i];
                beforeNum = nums[i];
                answer++;
            }
        }
        return answer;
    }
}
```