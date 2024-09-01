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
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        
        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headS = reverseList(mid);
        ListNode rerev = headS;
        
        while(head != null && headS != null){
            if(head.val != headS.val){
                break;
            }
            head = head.next;
            headS = headS.next;
        }
        reverseList(rerev);
        if(head == null || headS == null){
            return true;
        }
        return false;
    }
}