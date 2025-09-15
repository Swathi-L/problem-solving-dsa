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
    public void flatten(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root) {

        if(root == null) {
            return;
        }

        if(root.left != null) {
            TreeNode last = findLast(root.left);
            // System.out.println("last: " + last.val);
            last.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        helper(root.right);
    }
    
    public TreeNode findLast(TreeNode root) {
       while(root.right != null) {
        root = root.right;
       }
        return root;   
    }
}