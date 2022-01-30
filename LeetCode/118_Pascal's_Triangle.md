## 118. Pascal's Triangle
> Given an integer numRows, return the first numRows of Pascal's triangle. [link](https://leetcode.com/problems/pascals-triangle/)
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        answer.add(first);
        
        int row = 1;
        while (row < numRows) {
            List<Integer> beforeRow = answer.get(row - 1);
            List<Integer> nowRow = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                if (i == 0 || i == row) {
                    nowRow.add(1);
                    continue;
                }
                int num1 = beforeRow.get(i - 1);
                int num2 = beforeRow.get(i);
                nowRow.add(num1 + num2);
            }
            answer.add(nowRow);
            row++;
        }
        return answer;
    }
}
```