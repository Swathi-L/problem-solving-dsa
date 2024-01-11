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

        idxmap.put(0, new ArrayList<>(List.of(root.val)));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // queue to store corresponding indices
        Queue<Integer> iq = new LinkedList<>();
        iq.add(0);

        while(q.size() > 0) {
            TreeNode node = q.remove();
            int n_idx = iq.remove();

            if(node.left != null) {
                int l_idx = n_idx-1;
                q.add(node.left);
                iq.add(l_idx);

                if(idxmap.containsKey(l_idx)) {
                    List<Integer> nlist = idxmap.get(l_idx);
                    nlist.add(node.left.val);
                }
                else {
                    idxmap.put(l_idx, new ArrayList<>(List.of(node.left.val)));
                }
            }
            if(node.right != null) {
                int r_idx = n_idx+1;
                q.add(node.right);
                iq.add(r_idx);

                if(idxmap.containsKey(r_idx)) {
                    List<Integer> nlist = idxmap.get(r_idx);
                    nlist.add(node.right.val);
                }
                else {
                    idxmap.put(r_idx, new ArrayList<>(List.of(node.right.val)));
                }
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> nlist : idxmap.entrySet()) {
            result.add(nlist.getValue());
        }

        return result;
    }
}