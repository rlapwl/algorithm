## 206. Reverse Linked List
> Given the head of a singly linked list, reverse the list, and return the reversed list. [link](https://leetcode.com/problems/reverse-linked-list/)
```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
```