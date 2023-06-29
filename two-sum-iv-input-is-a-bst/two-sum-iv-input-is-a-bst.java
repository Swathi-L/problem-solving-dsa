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
    private List<Integer> inorderDFS(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
    
        List<Integer> left = inorderDFS(root.left);
        left.add(root.val);
        // List<Integer> right = inorderDFS(root.right);
        left.addAll(inorderDFS(root.right));
        return left;
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = inorderDFS(root);  
        
        int p1 = 0, p2 = nums.size()-1;

        while(p1 < p2) {
            int sum = nums.get(p1) + nums.get(p2);
            if(sum == k) {
                return true;
            }
            if(sum > k) {
                p2--;
            }else {
                p1++;
            }
            
        }

        return false; 
    }
}