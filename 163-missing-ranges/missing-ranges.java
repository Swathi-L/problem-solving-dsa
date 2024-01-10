class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
       
       int len = nums.length;
      
       List<List<Integer>> res = new ArrayList<>();

       if(len == 0) {
           List<Integer> pair = new ArrayList<>();
           pair.add(lower);
           pair.add(upper);
           res.add(pair);
           return res;
       }

       if(lower != nums[0]) {
           List<Integer> pair = new ArrayList<>();
           pair.add(lower);
           pair.add(nums[0]-1);
           res.add(pair);
       }
       for(int i=0; i<len-1; i++) {
           if(nums[i+1] - nums[i] != 1) {
               List<Integer> pair = new ArrayList<>();
               pair.add(nums[i] + 1);
               pair.add(nums[i+1] - 1);
               res.add(pair);
           }
       } 

       if(nums[len-1] != upper) {
           List<Integer> pair = new ArrayList<>();
           pair.add(nums[len-1]+1);
           pair.add(upper);
           res.add(pair);
       }
       return res;
    }
}