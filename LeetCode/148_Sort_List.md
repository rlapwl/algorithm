## 148. Sort List
> Given the head of a linked list, return the list after sorting it in ascending order. Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)? [link](https://leetcode.com/problems/sort-list/)
```
Input: head = [4,2,1,3]
Output: [1,2,3,4]
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        
        current.next = node1 != null ? node1 : node2;
        
        return dummy.next;
    }
    
    private ListNode middleNode(ListNode head) {
        ListNode left = head, right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode mid = left.next;
        left.next = null;
        return mid;
    }
}
```