class Solution {
    int count;
    public int countArrangement(int n) {
        // [1 2]
        // [1 2], [2,1]
        // [1 2 3]
        // [1 2 3] [2 3 1] [3 1 2] 
        // [1 3 2]
        // [1 2 3] [1 3 2] []
        // 
        helper(n, 1, new HashSet<>());
        return count;
    }

    void helper(int n, int idx, Set<Integer> numSet){
        if(idx > n) {
            count++;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!numSet.contains(i)) {
                // check beautiful arrangement
                if(i % idx == 0 || idx % i == 0) {
                    numSet.add(i);
                    helper(n, idx+1, numSet);
                    numSet.remove(i);
                }
            }
        }
    }
}