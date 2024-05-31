class Solution {
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> cur, Set<Integer> numset) {
        if(cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!numset.contains(nums[i])) {
                cur.add(nums[i]);
                numset.add(nums[i]);
                
                helper(nums, result, cur, numset);
                
                numset.remove(nums[i]);
                cur.remove(cur.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }
}