/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0, h=1;

        // binary search to find the low and high index
        while(reader.get(h) != Integer.MAX_VALUE 
            && target > reader.get(h)){
            l = h;
            h *= 2;
        }

        //binary search to find the index of target
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            else if(reader.get(mid) == Integer.MAX_VALUE 
                || reader.get(mid) > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}