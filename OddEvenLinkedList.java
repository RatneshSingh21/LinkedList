class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead = even;
        while(even!=null && even.next!=null)
        {
           odd.next=even.next;
           odd=odd.next;    // Move the odd pointer
           even.next=odd.next;
           even=even.next;   // Move the even pointer
        }
         odd.next = evenHead;// Connect odd list to even list
        return head;
        
    }
}
