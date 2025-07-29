class Solution {
    public int findMin(int[] nums) {
        int l=0, h=nums.length-1;

        while(l <= h) {
            int mid = l + (h-l)/2;

            // check if mid is lower than it's left and right neighbors if exist
            if((mid-1 < 0 || nums[mid-1] > nums[mid])
                && (mid+1 >= nums.length || nums[mid+1] > nums[mid])) {
                return nums[mid];
            }

            // check if right half is sorted, move to left as min lies in left
            // this also handles the scenario where both halved are sorted, then move to left
            // e.g [6,7,0,2,3,4,5]
            if(nums[mid] <= nums[h]) {
                h = mid - 1;
            }
            // if right half is not sorted, then left is sorted, move to right as the min element lies in right
            // e.g [5,6,7,2,3,4]
            else {
                l = mid + 1;
            }
        }
        // does not matter what we return here, as min is always guaranteed to be present in the array
        return -1;
    }
}