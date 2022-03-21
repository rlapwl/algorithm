## 56. Merge Intervals
> Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input. [link](https://leetcode.com/problems/merge-intervals/)
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int j = mergeList.size() - 1;
            int[] preInterval = mergeList.get(j);
            
            if (preInterval[1] >= intervals[i][0]) {
                if (preInterval[1] <= intervals[i][1]) {
                    mergeList.get(j)[1] = intervals[i][1];
                }
            } else {
                mergeList.add(intervals[i]);
            }
        }
        
        int[][] answer = new int[mergeList.size()][2];
        for (int i = 0; i < mergeList.size(); i++) {
            answer[i] = mergeList.get(i);
        }
        return answer;
    }
}
```