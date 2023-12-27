class Solution {

    public int dfs(int node, int[][] adj, int[] visit) {
        if(visit[node] != 0) {
            return visit[node];
        }
        visit[node] = -1;
        for(int neighbor : adj[node]) {
            int result = dfs(neighbor, adj, visit);
            if(result == -1) {
                return -1;
            }
        }
        visit[node] = 1;
        return 1;
    }
 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visit = new int[graph.length];
        
        for(int i=0; i<graph.length; i++) {
            dfs(i, graph, visit);
        }

        List<Integer> output = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            if(visit[i] == 1) {
                output.add(i);
            }
        }
        return output;
    }
}