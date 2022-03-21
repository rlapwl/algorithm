## 547. Number of Provinces
> There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c. A province is a group of directly or indirectly connected cities and no other cities outside of the group. You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise. Return the total number of provinces. [link](https://leetcode.com/problems/number-of-provinces/)
```
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
```
```java
class Solution {
    private int[] provinces;
    
    private int find(int x) {
        if (provinces[x] == x) {
            return x;
        }
        return find(provinces[x]);
    }
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        provinces[y] = x;
    }
    public int findCircleNum(int[][] isConnected) {
        provinces = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            provinces[i] = i;
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        Set<Integer> uniqueProvinces = new HashSet<>();
        for (int province : provinces) {
            uniqueProvinces.add(find(province));
        }
        return uniqueProvinces.size();
    }
}
```