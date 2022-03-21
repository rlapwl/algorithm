## 94. Binary Tree Inorder Traversal
> Given the root of a binary tree, return the inorder traversal of its nodes' values. [link](https://leetcode.com/problems/binary-tree-inorder-traversal/)
```
Input: root = [1,null,2,3]
Output: [1,3,2]
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
    private List<Integer> answer;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();    
        order(root);
        return answer;
    }
    
    private void order(TreeNode node) {
        if (node == null) {
            return;
        }
        
        order(node.left);
        answer.add(node.val);
        order(node.right);
    }
}
```