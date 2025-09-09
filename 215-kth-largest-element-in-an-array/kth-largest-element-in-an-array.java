class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int num : nums) {
            heap.add(num);
            if(heap.size() == k+1) {
                heap.remove();
            }
        }
        return heap.peek();
    }
}