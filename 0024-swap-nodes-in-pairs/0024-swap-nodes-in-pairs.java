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
        if(head == null || head.next == null){
            return head;
        }
        ListNode ptr = new ListNode(0);
        ptr.next = head;
        ListNode prev = ptr;
        while(head != null && head.next != null){
             ListNode first = head;
             ListNode second = head.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
            head = first.next;
        }
        
        return ptr.next;
    }
}