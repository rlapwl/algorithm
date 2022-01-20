## 230. Kth Smallest Element in a BST
> Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
```
Input: root = [5,3,6,2,4,null,null,1], k = 3
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
    int answer = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        preOrder(root);
        return answer;
    }
    
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        preOrder(root.left);
        if (--cnt == 0) {
            answer = root.val;
            return;
        }
        preOrder(root.right);
    }
}
```