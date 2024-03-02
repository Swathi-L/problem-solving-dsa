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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        
        helper(root);
        return isBalanced;
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);

        int diff = Math.abs(l - r);
        if(diff > 1) {
            isBalanced = false;
        }
        return Math.max(l, r) + 1;
    }
}