class Solution {
    public void moveZeroes(int[] nums) {
        
        boolean non_zero = false;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                non_zero = false;
                // swap with next non-zero element
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        non_zero = true;
                        break;
                    }
                }
                if(!non_zero) {
                    break;
                }
            }
        }
    }
}