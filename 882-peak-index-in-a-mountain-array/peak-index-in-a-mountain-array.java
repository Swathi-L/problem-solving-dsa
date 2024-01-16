class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=1, r=arr.length-2;

        while(l < r) {
            int mid = l + (r-l)/2;

            if(arr[mid+1] >= arr[mid]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}