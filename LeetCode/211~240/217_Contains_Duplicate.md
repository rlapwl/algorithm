## 217. Contains Duplicate
> Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. [link](https://leetcode.com/problems/contains-duplicate/)
```
Input: nums = [1,2,3,1]
Output: true
```
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }
            uniqueNums.add(num);
        }
        return false;
    }
}
```