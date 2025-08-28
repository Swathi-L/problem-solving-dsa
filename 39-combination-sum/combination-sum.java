class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();

       helper(candidates, target, 0, new ArrayList<>(), res); 
       return res;
    }

    void helper(int[] arr, int target, int i, List<Integer> combo, 
    List<List<Integer>> res) {

        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }

        if(i >= arr.length || target < 0){
            return;
        }

        // not choose
        helper(arr, target, i+1, combo, res);

        //choose
        combo.add(arr[i]);
        helper(arr, target-arr[i], i, combo, res);
        
        // backtrack
        combo.remove(combo.size()-1);    
    }
}