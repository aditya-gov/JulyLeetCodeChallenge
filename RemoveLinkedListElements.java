/*

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5



*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        if(head == null)
            return head;
        else {
            while(current != null && current.next != null){
                if(current.next.val == val)
                    current.next = current.next.next;
                else
                    current = current.next;
            }
        
            if(head.val == val)
                head = head.next;
        }
        return head;
    }
}