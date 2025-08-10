class Solution {
    public int findPairs(int[] nums, int k) {
       Set<Integer> numSet = new HashSet<>();
       Set<List<Integer>> pairSet = new HashSet<>();

       for(int num : nums) {
        int diff = num - k;
        int sum = num + k;
        
        if(numSet.contains(diff)) {
            List<Integer> pair = new ArrayList<>();
            pair.add(num);
            pair.add(diff);
            Collections.sort(pair);

            if(!pairSet.contains(pair)) {
                pairSet.add(pair);
            }
        }

        if(numSet.contains(sum)) {
            List<Integer> pair = new ArrayList<>();
            pair.add(num);
            pair.add(sum);
            Collections.sort(pair);

            if(!pairSet.contains(pair)) {
                pairSet.add(pair);
            }
        }
        numSet.add(num);
       }
       return pairSet.size();
    }
}