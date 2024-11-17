/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode mergedLL = new ListNode(-1); // Dummy node
        ListNode temp = mergedLL;

        // Merge the two sorted lists
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Append the remaining nodes
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // Skip dummy node
    }

    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle and split the list
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(right);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }
}
