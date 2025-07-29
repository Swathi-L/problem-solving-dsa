class Solution {
    private  int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        // binary search
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(nums[mid] == target) {
                if(mid-1 < 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    // move left
                    h = mid - 1;
                }
            }
            // move left
            else if(target < nums[mid]) {
                h = mid - 1;
            }
            // move right
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private  int findLast(int[] nums, int target) {
        int l=0, h=nums.length-1;

        while(l <= h){
            int mid = l + (h-l)/2;

            if(nums[mid] == target) {
                if(mid + 1 >= nums.length || nums[mid+1] != target) {
                    return mid;
                }
                else{
                    l = mid + 1;
                }
            }
            // move left
            else if(target < nums[mid]){
                h = mid - 1;
            }
            // move right
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public  int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        if(first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

}