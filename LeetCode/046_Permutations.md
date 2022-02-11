## 46. Permutations
> Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. [link](https://leetcode.com/problems/permutations/)
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```
```java
class Solution {
    private List<List<Integer>> answer;
    
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        permutation(new LinkedHashSet<>(), nums);
        return answer;
    }
    
    private void permutation(LinkedHashSet<Integer> pSet, int[] nums) {
        if (pSet.size() == nums.length) {
            answer.add(new ArrayList<>(pSet));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (pSet.contains(nums[i])) {
                continue;
            }
            pSet.add(nums[i]);
            permutation(pSet, nums);
            pSet.remove((Integer) nums[i]);
        }
    }
    
}
```