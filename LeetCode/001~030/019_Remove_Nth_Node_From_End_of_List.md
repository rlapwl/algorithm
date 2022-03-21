## 19. Remove Nth Node From End of List
> Given the head of a linked list, remove the nth node from the end of the list and return its head. [link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Input: head = [1,2], n = 1
Output: [1]
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
    private int endCnt = 0;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return permutation(head, n);
    }
    
    private ListNode permutation(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        
        head.next = permutation(head.next, n);
        if (++endCnt == n) {
            return head.next;
        }
        return head;
    }
}
```