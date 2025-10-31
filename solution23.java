class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    // Recursive function to merge lists from index left to right
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    
    // Helper function to merge two sorted lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;
        
        return dummy.next;
    }
}

  
