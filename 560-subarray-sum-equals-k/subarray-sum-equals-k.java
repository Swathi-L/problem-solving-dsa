class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, prefixSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        for(int i=0; i<n; i++) {
            prefixSum += nums[i];

            if(prefixSum == k) {
                count++;
            }
            if(prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            } 
            prefixSumFreq.put(prefixSum, 
                prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}