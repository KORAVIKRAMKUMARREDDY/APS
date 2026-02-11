class Solution { 
    /** 
     * Reverses nodes in k-group 
     * Given a linked list, reverse the nodes of a linked list k at a time 
     * @param head The head of the linked list 
     * @param k The group size for reversal 
     * @return The new head of the modified linked list 
     */ 
    public ListNode reverseKGroup(ListNode head, int k) { 
        // Create a dummy node to simplify edge cases 
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
       
        // Pointer to track the node before the current group 
        ListNode previousGroupTail = dummy; 
       
        while (previousGroupTail != null) { 
            // Check if there are at least k nodes remaining 
            ListNode currentNode = previousGroupTail; 
            for (int i = 0; i < k; i++) { 
                currentNode = currentNode.next; 
                if (currentNode == null) { 
                    // Less than k nodes remaining, return the result 
                    return dummy.next; 
                } 
            } 
           
            // Save pointers for the reversal process 
            ListNode groupStart = previousGroupTail.next;  // First node of current group 
            ListNode nextGroupStart = currentNode.next;     // First node of next group 
           
            // Disconnect the current group from the rest of the list 
            currentNode.next = null; 
           
            // Reverse the current group and connect it back 
            previousGroupTail.next = reverse(groupStart); 
           
            // After reversal, groupStart becomes the tail of the reversed group 
            groupStart.next = nextGroupStart; 
           
            // Move previousGroupTail to the tail of the current reversed group 
            previousGroupTail = groupStart; 
        } 
       
        return dummy.next; 
    } 
   
    /** 
     * Helper method to reverse a linked list 
     * @param head The head of the linked list to reverse 
     * @return The new head of the reversed linked list 
     */ 
    private ListNode reverse(ListNode head) { 
        // Use dummy node to build the reversed list 
        ListNode dummy = new ListNode(); 
        ListNode current = head; 
       
        // Iterate through the list and prepend each node to dummy 
        while (current != null) { 
            ListNode nextNode = current.next;  // Save the next node 
            current.next = dummy.next;          // Point current to the reversed list 
            dummy.next = current;                // Make current the new head of reversed list 
            current = nextNode;                  // Move to the next node 
        } 
       
        return dummy.next; 
    } 
}