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
    public ListNode oddEvenList(ListNode head) {
        int i = 1;
        ListNode node = head;
        while(node != null) {
            ListNode tmp = node;
            ListNode x = node.next;
            for (int j = 0; x!=null && j< i; j++) {
                tmp = tmp.next;
                x = x.next;
            }
            if (tmp == null || x == null) break;
            tmp.next = x.next;
            x.next = node.next;
            node.next = x;
            node = node.next;
            i++;
        }

        return head;
    }
}