class Solution {
    public void buildAdj(int n, int[][] edges, List<List<Integer>> adj) {

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public boolean dfs(int src, int dest, List<List<Integer>> adj, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        if(visited[src]) {
            return false;
        }
        visited[src] = true;

        for(int s : adj.get(src)) {
            if(dfs(s, dest, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        buildAdj(n, edges, adj);

        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
}