class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int max = 0, j=0;
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            if(nums[i] % 2 == 0 && nums[i] <= threshold) {
                count++;
                for(j=i+1; j<nums.length; j++) {
                    if((nums[j] % 2 == nums[j-1] % 2) || nums[j] > threshold) { 
                        break;
                    }
                    count++;
                }
            }
            if(count > max) {
                max = count;
            }
        }
        return max;
    }
}