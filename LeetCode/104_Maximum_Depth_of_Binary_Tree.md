## 104. Maximum Depth of Binary Tree
> Given the root of a binary tree, return its maximum depth. A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. [link](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
```
Input: root = [3,9,20,null,null,15,7]
Output: 3
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
    private int max;
    
    public int maxDepth(TreeNode root) {
        max = 0;
        findDepth(root, 0);
        return max;
    }
    
    private void findDepth(TreeNode root, int depth) {
        if (root == null) {
            max = Math.max(max, depth);
            return;
        }
        
        findDepth(root.left, depth + 1);
        findDepth(root.right, depth + 1);
    }
}
```