## 378. Kth Smallest Element in a Sorted Matrix
> Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix. Note that it is the kth smallest element in the sorted order, not the kth distinct element. You must find a solution with a memory complexity better than O(n2). [link](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
```
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
```
```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
        int min = matrix[0][0];
		int max = matrix[n - 1][n - 1];
		
		while (min <= max) {
			int mid = (max - min) / 2 + min;
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				if (matrix[i][0] > mid) {
					break;
				}
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] <= mid) {
						count++;
					}
				}
			}
			
			if (k <= count) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return min;
    }
}
```