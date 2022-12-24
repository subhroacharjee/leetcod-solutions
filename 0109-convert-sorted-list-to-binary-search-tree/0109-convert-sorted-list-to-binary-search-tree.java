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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int n = -1;
        List<Integer> arr = new ArrayList<>();
        while(head!=null) {
            arr.add(head.val);
            head = head.next;
            n++;
        }
        return dfs(0, n, arr);
    }
    
    private TreeNode dfs(int start, int end, List<Integer> arr) {
        if (start > end) return null;
        if (start == end) return new TreeNode(arr.get(start));
        
        int mid = (start + end)/2;
        
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = dfs(start, mid -1, arr);
        root.right = dfs(mid + 1, end, arr);
        
        return root;
    }
}