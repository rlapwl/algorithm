## 238. Product of Array Except Self
> Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation. [link](https://leetcode.com/problems/product-of-array-except-self/)
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
		
        int productOfNums = 1;
		int zeroCnt = 0;
		for (int num : nums) {
			if (num == 0) {
				zeroCnt++;
				continue;
			}
			productOfNums *= num;
		}
		
		if (zeroCnt > 1) {
			productOfNums = 0;
		}
		for (int i = 0; i < nums.length; i++) {
			if (zeroCnt == 1 && nums[i] != 0) {
				answer[i] = 0;
			} else if (nums[i] == 0) {
                answer[i] = productOfNums;
            } else {
				answer[i] = (productOfNums / nums[i]);
			}
		}
		return answer;
    }
}
```