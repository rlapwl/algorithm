## 78. Subsets
> Given an integer array nums of unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets. Return the solution in any order. [link](https://leetcode.com/problems/subsets/)
```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```
```java
class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        
        for (int i = 1; i <= nums.length; i++) {
            order(0, i, new ArrayList<>(), nums);
        }
        return answer;
    }
    
    private void order(int idx, int cnt, List<Integer> list, int[] nums) {
        if (list.size() == cnt) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            order(i + 1, cnt, list, nums);
            list.remove(new Integer(nums[i]));
        }
    }
}
```