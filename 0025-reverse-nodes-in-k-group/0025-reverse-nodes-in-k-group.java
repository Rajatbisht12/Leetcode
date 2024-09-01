class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        
        // Step 1: Count the total number of nodes in the list
        ListNode countNode = head;
        int count = 0;
        while (countNode != null) {
            countNode = countNode.next;
            count++;
        }
        
        // If there are fewer than k nodes, return the original list
        if (count < k) {
            return head;
        }
        
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        // Process each k-group
        while (count >= k) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode prev = null;
            ListNode curr = groupStart;
            ListNode next = null;
            
            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            // Connect the previous group with the new reversed group
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            
            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
            
            // Reduce the count of remaining nodes
            count -= k;
        }
        
        return dummy.next;
    }
}
