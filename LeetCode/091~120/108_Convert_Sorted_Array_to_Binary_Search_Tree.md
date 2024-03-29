## 108. Convert Sorted Array to Binary Search Tree
> Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree. [link](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
```
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
```
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return insert(nums, 0, nums.length - 1);
    }
    
    private TreeNode insert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(nums, start, mid - 1);
        root.right = insert(nums, mid + 1, end);
        return root;
    }
}
```