## 86. Partition List
> Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions. [link](https://leetcode.com/problems/partition-list/)
```
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
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
    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode(0);
        ListNode tailNode = new ListNode(0);
        ListNode h = headNode;
        ListNode t = tailNode;
        
        while (head != null) {
            
            if (head.val < x) {
                h.next = new ListNode(head.val);
                h = h.next;
            } else {
                t.next = new ListNode(head.val);
                t = t.next;
            }
            head = head.next;
        }
        
        h.next = tailNode.next;
        return headNode.next;
    }
}
```
