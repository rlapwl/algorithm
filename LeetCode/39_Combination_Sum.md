## 39. Combination Sum
> Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order. The same number may be chosen from candidates an unlimited number of times. [link](https://leetcode.com/problems/combination-sum/)
```
Input: candidates = [2,3,6,7], target = 7  
Output: [[2,2,3],[7]]
```
```java
class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        for (int i = 0; i < candidates.length; i++) {
            int number = candidates[i];
            
            List<Integer> numbers = new ArrayList<>();
            numbers.add(number);
            
            combination(candidates, target, i, number, numbers);
        }
        return answer;
    }
    
    private void combination(int[] candidates, int target, int idx, int sum, List<Integer> numbers) {
        
        if (target == sum) {
            answer.add(new ArrayList<>(numbers));
            return;
        }
        
        if (target < sum) {
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            int number = candidates[i];
            numbers.add(number);
            
            combination(candidates, target, i, sum + number, numbers);
            
            numbers.remove(numbers.size() - 1);
        }
    }
}
```