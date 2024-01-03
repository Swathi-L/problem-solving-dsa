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

    public boolean bfs(int src, int dest, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while(q.size() > 0) {
            int node = q.remove();
            if(node == dest) {
                return true;
            }

            for(int n : adj.get(node)) {
                if(!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        buildAdj(n, edges, adj);
        
        boolean visited[] = new boolean[n];
        return bfs(source, destination, adj, visited);
    }
}