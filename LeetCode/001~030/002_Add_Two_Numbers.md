## 02. Add Two Numbers
> You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. [link](https://leetcode.com/problems/add-two-numbers/)
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode node = answer;
        
        int plusNum = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + plusNum;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + plusNum;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + plusNum;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            plusNum = sum / 10;
            sum = sum % 10;
            
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        if (plusNum > 0) {
            node.next = new ListNode(plusNum);
        }
        return answer.next;
    }
}
```