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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        // store index and elements in that column/index
        // treemap stores in ascending order of keys
        Map<Integer, List<Integer>> idxmap = new TreeMap<>();

        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // queue to store corresponding indices
        Queue<Integer> iq = new LinkedList<>();
        iq.add(0);

        while(q.size() > 0) {
            TreeNode node = q.remove();
            int n_idx = iq.remove();

            if(!idxmap.containsKey(n_idx)) {
                idxmap.put(n_idx, new ArrayList<>(List.of(node.val)));
            }
            else {
                idxmap.get(n_idx).add(node.val);
            }

            if(node.left != null) {
                q.add(node.left);
                iq.add(n_idx-1);
            }
            if(node.right != null) {
                q.add(node.right);
                iq.add(n_idx+1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> nlist : idxmap.entrySet()) {
            result.add(nlist.getValue());
        }

        return result;
    }
}