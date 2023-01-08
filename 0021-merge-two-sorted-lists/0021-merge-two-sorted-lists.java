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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
      return head2;
    } else if (head2 == null) {
      return head1;
    }


    ListNode mergedHead = null;
    if (head1.val <= head2.val) {
      mergedHead = head1;
      head1 = head1.next;
    } else {
      mergedHead = head2;
      head2 = head2.next;
    }

    ListNode mergedTail = mergedHead;
  
    while (head1 != null && head2 != null) {
      ListNode temp = null;
      if (head1.val <= head2.val) {
        temp = head1;
        head1 = head1.next;
      } else {
        temp = head2;
        head2 = head2.next;
      }

      mergedTail.next = temp;
      mergedTail = temp;
    }

    if (head1 != null) {
      mergedTail.next = head1;
    } else if (head2 != null) {
      mergedTail.next = head2;
    }

    return mergedHead;
    }
}