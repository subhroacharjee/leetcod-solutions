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
    public ListNode middleNode(ListNode head) {
        List<ListNode> holder = new ArrayList<>();
        
        ListNode node = head;
        while (node != null) {
            holder.add(node);
            node = node.next;
        }
        int n = holder.size();
        
        return holder.get(n/2);
    }
}