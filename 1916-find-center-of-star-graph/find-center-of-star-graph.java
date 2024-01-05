class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] indeg = new int[n+1];

        for(int i=0; i < edges.length; i++) {
            indeg[edges[i][0]] += 1;
            indeg[edges[i][1]] += 1;
        }
        for(int i=1; i <= n; i++) {
            if(indeg[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}