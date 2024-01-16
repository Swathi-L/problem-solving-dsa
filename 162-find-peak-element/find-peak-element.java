class Solution {
    public int findPeakElement(int[] nums) {
        
        int n=nums.length-1, left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            int lv = Integer.MIN_VALUE, rv = Integer.MIN_VALUE;

            if(mid-1 >= 0) {
                lv = nums[mid-1];
            }
            if(mid+1 <= n) {
                rv = nums[mid+1];
            }

            if(lv < nums[mid] && rv < nums[mid]) {
                return mid;
            }
            if(lv > rv) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
}