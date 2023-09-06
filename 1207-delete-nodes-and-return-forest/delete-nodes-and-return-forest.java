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

    public void helper(TreeNode root, Set<Integer> delSet, List<TreeNode> output) {
        if(root == null) {
            return;
        }
        helper(root.left, delSet, output);
        helper(root.right, delSet, output);

        if(root != null && delSet.contains(root.val)) {
            if(root.left != null && !delSet.contains(root.left.val)) {
                output.add(root.left);
            }
            if(root.right != null && !delSet.contains(root.right.val)) {
                output.add(root.right);
            }
        }

        if(root.left != null && delSet.contains(root.left.val)) {
            root.left = null;
        }
        if(root.right != null && delSet.contains(root.right.val)) {
            root.right = null;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       List<TreeNode> output = new ArrayList<>();
       Set<Integer> delSet = new HashSet<>();
       for(int num : to_delete) {
           delSet.add(num);
       }
       if(!delSet.contains(root.val)) {
           output.add(root);
       }
       helper(root, delSet, output);
        return output;
    }
}