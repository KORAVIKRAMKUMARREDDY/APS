class Solution { 
    /** 
     * Merges two sorted linked lists into one sorted linked list. 
     * The merge is done recursively by comparing the values of the current nodes. 
     *  
     * @param list1 The head of the first sorted linked list 
     * @param list2 The head of the second sorted linked list 
     * @return The head of the merged sorted linked list 
     */ 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { 
        // Base case: if list1 is empty, return list2 
        if (list1 == null) { 
            return list2; 
        } 
       
        // Base case: if list2 is empty, return list1 
        if (list2 == null) { 
            return list1; 
        } 
       
        // Compare the values of the current nodes 
        if (list1.val <= list2.val) { 
            // If list1's value is smaller or equal, choose list1's node 
            // Recursively merge the rest of list1 with list2 
            list1.next = mergeTwoLists(list1.next, list2); 
            return list1; 
        } else { 
            // If list2's value is smaller, choose list2's node 
            // Recursively merge list1 with the rest of list2 
            list2.next = mergeTwoLists(list1, list2.next); 
            return list2; 
        } 
    } 
}