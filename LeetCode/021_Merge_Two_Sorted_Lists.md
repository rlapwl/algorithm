## 21. Merge Two Sorted Lists
> You are given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists. [link](https://leetcode.com/problems/merge-two-sorted-lists/)
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```
#### Solution 1
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode answer = node;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = new ListNode(list1.val);
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                node = node.next;
                list2 = list2.next;
            }
        }
        
        while (list1 != null) {
            node.next = new ListNode(list1.val);
            node = node.next;
            list1 = list1.next;
        }
        
        while (list2 != null) {
            node.next = new ListNode(list2.val);
            node = node.next;
            list2 = list2.next;
        }
        return answer.next;
    }
}
```

#### Solution 2
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
```