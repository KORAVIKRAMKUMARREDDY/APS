public class Solution { 
    /** 
     * Detects if a linked list has a cycle and returns the node where the cycle begins. 
     * Uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare). 
     *  
     * @param head The head of the linked list 
     * @return The node where the cycle begins, or null if no cycle exists 
     */ 
    public ListNode detectCycle(ListNode head) { 
        // Initialize two pointers: fast (hare) and slow (tortoise) 
        ListNode fastPointer = head; 
        ListNode slowPointer = head;       
        // Phase 1: Detect if a cycle exists using two-pointer technique 
        // Fast pointer moves 2 steps, slow pointer moves 1 step 
        while (fastPointer != null && fastPointer.next != null) { 
            slowPointer = slowPointer.next;          // Move slow pointer one step 
            fastPointer = fastPointer.next.next;     // Move fast pointer two steps           
            // If pointers meet, a cycle exists 
            if (slowPointer == fastPointer) { 
                // Phase 2: Find the start of the cycle 
                // Move one pointer to head and keep the other at meeting point 
                ListNode startPointer = head;               
                // Move both pointers one step at a time until they meet 
                // The meeting point is the start of the cycle 
                while (startPointer != slowPointer) { 
                    startPointer = startPointer.next; 
                    slowPointer = slowPointer.next; 
                }               
                // Return the node where the cycle begins 
                return startPointer; 
            } 
        } 
       
        // No cycle found 
        return null; 
    } 
} 
