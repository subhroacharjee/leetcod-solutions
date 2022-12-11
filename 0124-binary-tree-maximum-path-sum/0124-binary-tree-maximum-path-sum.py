# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.result = root.val
        def maxpath(node):
            if not node: return 0
            x = node.val
            l = max(0,maxpath(node.left )) # ignore "left" branch if negative
            r = max(0,maxpath(node.right)) # ignore "right" branch if negative
            self.result = max(self.result, x+l+r ) # Check if merged arc-path (left+node+right) beats the current result
            return max(x+l,x+r) # Try to build maximum branch value
        maxpath(root)
        return self.result
        