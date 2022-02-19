## 98. Validate Binary Search Tree
> Given the root of a binary tree, determine if it is a valid binary search tree (BST). [link](https://leetcode.com/problems/validate-binary-search-tree/)
```
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Double leftVal = - Double.MAX_VALUE;
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (root.val <= leftVal) {
                return false;
            }
            leftVal = (double) root.val;
            root = root.right;
        }
        return true;
    }
}
```