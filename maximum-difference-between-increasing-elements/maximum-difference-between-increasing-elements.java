class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0], maxDiff = -1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > min) {
                int diff = nums[i] - min;
                maxDiff = Math.max(maxDiff, diff);
            }
            else {
                min = nums[i];
            }
        }
        return maxDiff;
    }
}