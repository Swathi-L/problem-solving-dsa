class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int l = 0, r = nums.length-1;
        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum < k && sum > max) {
                max = sum;
            }

            if(sum >= k) {
                r--;
            } else {
                l++;
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}