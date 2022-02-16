## 239. Sliding Window Maximum
> You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. [link](https://leetcode.com/problems/sliding-window-maximum/)
```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

#### Solution 1
- 시간복잡도: O(nk) => Time Limit Exceeded 발생함.
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
		int max = Integer.MIN_VALUE;
		int idx = 0;
		while (idx < nums.length) {
			if (idx == 0) {
				while (idx < k) {
					max = Math.max(max, nums[idx++]);
				}
				answer[idx - k] = max;
				continue;
			}
			
			if (nums[idx - k] == max) {
				max = Integer.MIN_VALUE;
				for (int i = idx - k + 1; i <= idx; i++) {
					max = Math.max(max, nums[i]);
				}
			} else {
				max = Math.max(max, nums[idx]);
			}
			idx++;
			answer[idx - k] = max;
		}
		return answer;
    }
}
```

#### Solution 2
- 시간복잡도: O(n)
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		int[] answer = new int[nums.length - k + 1];
		Deque<Integer> queue = new LinkedList<>();
		int i;
		for (i = 0; i < k; i++) {
			
			while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
				queue.removeLast();
			}
			queue.add(i);
		}
		
		for (; i < nums.length; i++) {
			answer[i - k] = nums[queue.peek()];
			
			while (!queue.isEmpty() && i - k >= queue.peek()) {
				queue.remove();
			}
			
			while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
				queue.removeLast();
			}
			queue.add(i);
		}
		answer[i - k] = nums[queue.peek()];
		return answer;
	}
}
```