class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=null;
       
        while(fast!=null && fast.next!=null)
        {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
      temp.next=slow.next;
      return head;
    }
}
