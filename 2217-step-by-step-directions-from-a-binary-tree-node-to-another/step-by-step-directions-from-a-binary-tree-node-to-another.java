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
    public String getDirections(TreeNode root, int startValue, int destValue) {
       
       List<Character> l1 = new ArrayList<>();
       List<Character> l2 = new ArrayList<>();
       l1 = getRootToNodePath(root, startValue, l1);
       l2 = getRootToNodePath(root, destValue, l2);
    //    System.out.println(l1);
    //    System.out.println(l2);

        int p1 =0, p2 =0;
        boolean change;

        StringBuilder result = new StringBuilder();

        while(p1 < l1.size() && p2 < l2.size()) {
            if(l1.get(p1) != l2.get(p2)) {
                break;
            }
            p1++;
            p2++;
        }

        if(p1 == 0){
            
            for(int i=0; i < l1.size(); i++) {
                result.append('U');
            }
            for(int i=0; i < l2.size(); i++) {
                result.append(l2.get(i));
            }
        } else {
            for(int i=p1; i < l1.size(); i++) {
                result.append('U');
            }
            for(int i=p2; i < l2.size(); i++) {
                result.append(l2.get(i));
            }
        }
       return result.toString(); 
    }

    List<Character> getRootToNodePath(TreeNode root, int val, List<Character> path){
       
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            List<Character> res = new ArrayList<>(path);
            return res;
        }

        // go left
        path.add('L');
        List<Character> left = getRootToNodePath(root.left, val, path);
        path.remove(path.size()-1);

        if(left != null){
            return left;
        }

        //right
        path.add('R');
        List<Character> right = getRootToNodePath(root.right, val, path);

        path.remove(path.size()-1);

        if(right != null){
            return right;
        }

        return null;
    }
}