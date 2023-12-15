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
    public TreeNode deleteLeaves(TreeNode root, List<Integer> leaves) {
        if(root == null) {
            return root;
        }
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }
        root.left = deleteLeaves(root.left, leaves);
        root.right = deleteLeaves(root.right, leaves);
        return root;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        while(root != null){
            List<Integer> leaves = new ArrayList<>();
            root = deleteLeaves(root, leaves); 
            result.add(leaves);
        }
        return result;
    }
}