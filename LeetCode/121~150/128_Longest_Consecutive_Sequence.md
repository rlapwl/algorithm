## 128. Longest Consecutive Sequence
> Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. You must write an algorithm that runs in O(n) time. [link](https://leetcode.com/problems/longest-consecutive-sequence/)
```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}
		
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			int down = nums[i] - 1;
			while (numSet.contains(down)) {
				numSet.remove(down);
				down--;
			}
			
			int up = nums[i] + 1;
			while (numSet.contains(up)) {
				numSet.remove(up);
				up++;
			}
			answer = Math.max(answer, up - down - 1);
		}
		return answer;
    }
}
```