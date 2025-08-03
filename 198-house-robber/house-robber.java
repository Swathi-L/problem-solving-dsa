class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        // 1 2 3 1
        // 1
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(i == 1) {
                // 1 2
                dp[1] = Math.max(dp[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            }
        }
        return dp[nums.length-1];
    }
}