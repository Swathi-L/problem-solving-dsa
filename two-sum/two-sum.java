class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            
            int diff = target - nums[i];

            if(numCount.containsKey(diff)) {
                result[0] = numCount.get(diff);
                result[1] = i;
                break;
            }           
            // insert into map
            else {
                numCount.put(nums[i], i);
            }
        }
        return result;
    }
}