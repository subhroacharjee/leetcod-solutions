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
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        ListNode node = removeNodes(head.next);
        if (node == null) return head;
        else if (node.val > head.val) return node;
        else {
            head.next = node;
            return head;
        }
    }
}