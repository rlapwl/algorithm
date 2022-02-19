## 105. Construct Binary Tree from Preorder and Inorder Traversal
> Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree. [link](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
```
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		return genNode(preorder, inorder, 0, 0, inorder.length - 1);
    }
	private TreeNode genNode(int[] preorder, int[] inorder, int preorderIdx, int inorderStartIdx, int inorderEndIdx) {
		if (preorderIdx >= preorder.length || inorderStartIdx > inorderEndIdx) {
			return null;
		}
		
		TreeNode node = new TreeNode(preorder[preorderIdx]);
		int inorderIdx = 0;
		for (int i = inorderStartIdx; i <= inorderEndIdx; i++) {
			if (inorder[i] == node.val) {
				inorderIdx = i;
				break;
			}
		}
		
		node.left = genNode(preorder, inorder, preorderIdx + 1, inorderStartIdx, inorderIdx - 1);
		// (inorderIndex - inorderStartIndex + 1) => 중위 순회에서 왼쪽 노드의 수
		node.right = genNode(preorder, inorder, preorderIdx + inorderIdx - inorderStartIdx + 1, inorderIdx + 1, inorderEndIdx);
		return node;
	}
}
```