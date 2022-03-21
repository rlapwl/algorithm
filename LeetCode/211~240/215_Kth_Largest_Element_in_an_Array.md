## 215. Kth Largest Element in an Array
> Given an integer array nums and an integer k, return the kth largest element in the array. Note that it is the kth largest element in the sorted order, not the kth distinct element. [link](https://leetcode.com/problems/kth-largest-element-in-an-array/)
```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        
        while (--k > 0) {
            queue.poll();
        }
        return queue.poll();
    }
}
```