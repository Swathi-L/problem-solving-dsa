class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       helper(candidates, target, 0, new ArrayList<>()); 
       return res;
    }

    void helper(int[] arr, int target, int i, List<Integer> combo) {

        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }

        if(i >= arr.length || target < 0){
            return;
        }

        // not choose
        helper(arr, target, i+1, combo);

        //choose
        combo.add(arr[i]);
        helper(arr, target-arr[i], i, combo);
        
        // backtrack
        combo.remove(combo.size()-1);    
    }
}