## 102. Binary Tree Level Order Traversal
> Given the root of a binary tree, return the level order traversal of its nodes' values. [link](https://leetcode.com/problems/binary-tree-level-order-traversal/)
```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
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
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(root.val);
            answer.add(numbers);
            
            order(0, root);
        }
        return answer;
    }
    
    private void order(int level, TreeNode root) {
        
        if (root.left == null && root.right == null) {
            return;
        }
        
        level += 1;
        if (answer.size() < (level + 1)) {
            answer.add(new ArrayList<>());    
        } 

        List<Integer> subNumbers = answer.get(level);
        if (root.left != null) {
            subNumbers.add(root.left.val);
            order(level, root.left);
        }
        if (root.right != null) {
            subNumbers.add(root.right.val);
            order(level, root.right);
        }
    }
}
```