class Solution {
    public void reorderList(ListNode head) {
         ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
           slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid=slow;

        ListNode prev=null;
        ListNode curr=mid.next;
        mid.next=null;
        ListNode next;

        while(curr!=null)
        {
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        }

        //alt merge -zigzag merge

        ListNode left=head;
        ListNode right=prev;
        ListNode nextL,nextR;

        while(left!=null && right!=null)
        {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            left=nextL;
            right=nextR;
        }
    }
}
