class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            
            if (prev.next == current) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            
            current = current.next;
        }
        
        return dummy.next;
    }
}