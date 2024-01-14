class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();

        int len = heights.length;

        res.add(len-1);
        int max = heights[len-1];
        for(int i=len-2; i>=0; i--) {
            if(heights[i] > max) {
                res.add(i);
                max = heights[i];
            }
        }

        int[] result = new int[res.size()];
        for(int i=res.size()-1, j=0; i>=0; i--, j++) {
            result[j] = res.get(i);
        }
        return result;
    }
}