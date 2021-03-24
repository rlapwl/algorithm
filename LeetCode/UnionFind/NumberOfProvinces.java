import java.util.*;

// [547] Number of Provinces Medium
public class NumberOfProvinces {
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