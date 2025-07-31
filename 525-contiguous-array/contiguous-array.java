class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0, sum=0;
        Map<Integer, Integer> sumIdxMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if(sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if(sumIdxMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIdxMap.get(sum));
            } else {
                sumIdxMap.put(sum, i);
            }
        }

        return maxLen;
    }
}