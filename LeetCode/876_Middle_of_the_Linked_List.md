## 876. Middle of the Linked List
> Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node. [link](https://leetcode.com/problems/middle-of-the-linked-list/)
```
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
```
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
    public ListNode middleNode(ListNode head) {
        ListNode left = head, right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return right == null ? left : left.next;
    }
}
```