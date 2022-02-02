## 24. Swap Nodes in Pairs
> Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.) [link](https://leetcode.com/problems/swap-nodes-in-pairs/)
```
Input: head = [1,2,3,4]
Output: [2,1,4,3]
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
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = new ListNode();
        ListNode answer = node;
        
        while (head != null && head.next != null) {
            int val1 = head.val;
            head = head.next;
            int val2 = head.val;
            head = head.next;
            
            node.next = new ListNode(val2);
            node = node.next;
            node.next = new ListNode(val1);
            node = node.next;
        }
        
        if (head != null) {
            node.next = new ListNode(head.val);
        }
        
        return answer.next;
    }
}
```