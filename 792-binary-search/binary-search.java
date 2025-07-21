class Solution {
    int binarySearch(int arr[], int l, int r, int x)
    {
        while(l <= r) {
            int midIdx = l + ((r - l) / 2);
            if(arr[midIdx] == x) {
                return midIdx;
            }
            if(arr[midIdx] > x) {
                r = midIdx - 1;
            } else {
                l = midIdx + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
}