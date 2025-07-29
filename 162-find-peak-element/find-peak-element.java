class Solution {
    public int findPeakElement(int[] nums) {
        int l=0, h=nums.length-1;

        while(l <= h) {
            int mid = l + (h-l)/2;
            if((mid - 1 < 0 || nums[mid] > nums[mid-1])
                && (mid + 1 >= nums.length || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // go left if left neighbor is larger than mid
            else if(mid - 1 >= 0 && nums[mid] < nums[mid-1]) {
                h = mid-1;
            }
            // go right if right neighbor is larger than mid
            else {
                l = mid+1;
            }
        }
        // does not matter what is returned here 
        // as there is a guaranteed peek in the array
        return -1;
    }
}