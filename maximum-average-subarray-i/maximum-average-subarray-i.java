class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int p1 = 0, p2 = k-1, sum = 0;

        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        double avg = (double)sum / k;
        double max = avg;
        p1++;
        p2++;

        while(p2 < nums.length) {
            sum = sum - nums[p1-1] + nums[p2];
            avg = (double)sum / k;
            if(avg > max) {
                max = avg;
            }
            p1++;
            p2++;
        }
        return max;
    }
}