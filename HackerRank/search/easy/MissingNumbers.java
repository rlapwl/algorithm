import java.util.*;

public class MissingNumbers {
    // Solution1
    static int[] solution1(int[] arr, int[] brr) {
        Set<Integer> missNums = new HashSet<>();
        int j = 0;
        for (int i = 0; i < brr.length; i++) {
            if (j == arr.length) {
                missNums.add(brr[i]);
                continue;
            }
            if (arr[j] != brr[i]) {
                missNums.add(brr[i]);
                continue;
            }
            j++;
        }
        
        int[] result = new int[missNums.size()];
        int i = 0;
        for (Integer num : missNums) {
            result[i] = num;
            i++;
        }
        Arrays.sort(result);
        return result;
    }

    // Solution2
    public int[] solution2(int[] arr, int[] brr) {
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
        for (Entry<Integer, Integer> entry : map.entrySet()) {
          result[i++] = entry.getKey();
        }
    
        return result;
      }
}