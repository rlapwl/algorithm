import java.util.*;

public class MissingNumbers {
    public int[] solution(int[] arr, int[] brr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
    
        for (int i : brr) {
          map.put(i, map.getOrDefault(i, 0) + 1);
        }
    
        for (int i : arr) {
          if ((map.get(i) - 1) == 0)
            map.remove(i);
          else
            map.put(i, (map.get(i) - 1));
        }
    
        int[] result = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          result[i++] = entry.getKey();
        }
    
        return result;
      }
}