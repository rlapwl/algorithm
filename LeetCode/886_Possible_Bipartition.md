## 886. Possible Bipartition
> We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group. [link](https://leetcode.com/problems/possible-bipartition/)
```
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
```
```java
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> record = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            record.add(new ArrayList<>());
        }
        
        for (int[] dislike : dislikes) {
            int a = dislike[0] - 1;
            int b = dislike[1] - 1;
            record.get(a).add(b);
            record.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] group = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                if (!isBipartition(i, record, visited, group)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isBipartition(int cur, List<List<Integer>> record, boolean[] visited, boolean[] group) {
        List<Integer> nextList = record.get(cur);
        for (int next : nextList) {
            if (!visited[next]) {
                visited[next] = true;
                group[next] = !group[cur];
                
                if (!isBipartition(next, record, visited, group)) {
                    return false;
                }
            } else if (group[next] == group[cur]) {
                return false;
            }
        }
        return true;
    }
}
```