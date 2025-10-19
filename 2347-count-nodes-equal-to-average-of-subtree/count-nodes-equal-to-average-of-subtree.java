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
    int result = 0;
    public int[] findSumCount(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }

        int[] left = findSumCount(root.left);
        int[] right = findSumCount(root.right);

        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;

        if(count != 0 && root.val == sum / count) {
            result++;
        }

        return new int[]{count, sum};
    }

    public int averageOfSubtree(TreeNode root) {
        findSumCount(root);
        return result;
    }
}