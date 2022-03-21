## 347. Top K Frequent Elements
> Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order. [link](https://leetcode.com/problems/top-k-frequent-elements/)
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```
```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        
        for (int num : count.keySet()) {
            heap.add(num);
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = heap.poll();
        }
        return answer;
    }
}
```