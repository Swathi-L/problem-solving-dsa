class Solution {
    private int findMinLength(int[] nums, int idx, int degree) {
        int count = 0, i=0;
        int num = nums[idx];
        for(i=idx; i<nums.length; i++) {
            if(nums[i] == num) {
                count++;
            }
            if(count == degree) {
                break;
            }
        }
        return i-idx+1;
    }

    public int findShortestSubArray(int[] nums) {
        int degree = 1, result=Integer.MAX_VALUE;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashSet<Integer> lenSet = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(countMap.containsKey(nums[i])) {
                int count = countMap.get(nums[i]);
                countMap.put(nums[i], count+1); 

                if(count+1 > degree) {
                    degree = count+1;
                }
            }else {
                countMap.put(nums[i], 1);
            }
        }

        for(int i=0; i<nums.length; i++) {
            int c = countMap.get(nums[i]);
            
            if(c == degree && !lenSet.contains(nums[i])) {
                int minLen = findMinLength(nums, i, degree);
                if(minLen < result) {
                    result = minLen;
                }
                lenSet.add(nums[i]);
            }
        }
        return result;
    }
}