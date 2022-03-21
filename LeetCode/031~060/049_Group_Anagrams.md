## 49. Group Anagrams
> Given an array of strings strs, group the anagrams together. You can return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. [link](https://leetcode.com/problems/group-anagrams/)
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] arrayStr = str.toCharArray();
            Arrays.sort(arrayStr);
            
            String orderStr = new String(arrayStr);
            if (map.get(orderStr) == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(orderStr, list);
            } else {
                map.get(orderStr).add(str);
            }
        }
        
        for (List<String> list : map.values()) {
            answer.add(list);
        }
        return answer;
    }
}
```