## 54. Spiral Matrix
> Given an m x n matrix, return all elements of the matrix in spiral order. [link](https://leetcode.com/problems/spiral-matrix/)
```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
		int moveCnt = 0;
		int totalCnt = matrix.length * matrix[0].length;
		while (answer.size() < totalCnt) {
			for (int i = moveCnt; i < matrix[0].length - moveCnt; i++) {
				answer.add(matrix[moveCnt][i]);
			}
			if (answer.size() == totalCnt) {
				break;
			}
			moveCnt++;
			
			for (int i = moveCnt; i < matrix.length - moveCnt; i++) {
				answer.add(matrix[i][matrix[0].length - moveCnt]);
			}
			if (answer.size() == totalCnt) {
				break;
			}
			
			for (int i = matrix[0].length - moveCnt; i >= moveCnt - 1; i--) {
				answer.add(matrix[matrix.length - moveCnt][i]);
			}
			if (answer.size() == totalCnt) {
				break;
			}
			
			for (int i = matrix.length - moveCnt - 1; i >= moveCnt; i--) {
				answer.add(matrix[i][moveCnt - 1]);
			}
			if (answer.size() == totalCnt) {
				break;
			}
		}
		return answer;
    }
}
```