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

    public TreeNode helper(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        if(left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        
        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = helper(nums, left, mid-1);
        newNode.right = helper(nums, mid+1, right);

        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}