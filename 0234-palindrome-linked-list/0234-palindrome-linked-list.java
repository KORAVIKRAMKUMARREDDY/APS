class Solution { 
    public boolean isPalindrome(ListNode head) { 
        // Use two pointers to find the middle of the linked list 
        ListNode slow = head; 
        ListNode fast = head.next; 
       
        // Move slow pointer one step and fast pointer two steps each iteration 
        // When fast reaches the end, slow will be at the middle 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
       
        // Split the list into two halves 
        // The second half starts from slow.next 
        ListNode current = slow.next; 
        slow.next = null;  // Disconnect the first half from the second half 
       
        // Reverse the second half of the linked list 
        ListNode previous = null; 
        while (current != null) { 
            ListNode temp = current.next;  // Store the next node 
            current.next = previous;       // Reverse the pointer 
            previous = current;             // Move previous forward 
            current = temp;                 // Move to the next node 
        } 
       
        // Compare the first half with the reversed second half 
        // previous now points to the head of the reversed second half 
        while (previous != null) { 
            if (previous.val != head.val) { 
                return false;  // Values don't match, not a palindrome 
            } 
            previous = previous.next; 
            head = head.next; 
        } 
       
        return true;  // All values matched, it's a palindrome 
    } 
} 