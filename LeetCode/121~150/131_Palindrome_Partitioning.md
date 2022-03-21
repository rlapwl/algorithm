## 131. Palindrome Partitioning
> Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s. A palindrome string is a string that reads the same backward as forward. [link](https://leetcode.com/problems/palindrome-partitioning/)
```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```
```java
class Solution {
    public List<List<String>> partition(String s) {
		List<List<String>> answer = new ArrayList<>();
		dfs(0, answer, new ArrayList<>(), s);
		return answer;
    }
	
	private void dfs(int start, List<List<String>> answer, List<String> currentList, String s) {
		if (start >= s.length()) {
			answer.add(new ArrayList<>(currentList));
			return;
		}
		
		for (int idx = start; idx < s.length(); idx++) {
			String sub = s.substring(start, idx + 1);
			if (isPalindrome(sub)) {
				currentList.add(sub);
				dfs(idx + 1, answer, currentList, s);
				currentList.remove(currentList.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
}
```