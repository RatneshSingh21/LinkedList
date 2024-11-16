public class Solution {
   public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected
                break;
            }
        }

        // If no cycle is found, return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the starting node of the cycle
        slow = head; // Move slow pointer to the head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both pointers meet at the start of the cycle
        return slow;
    }
    }
