class Solution {
    public void findIndegree(int n, int[][] rel, int[] indeg) {
        for(int i=0; i<rel.length; i++) {
            int course = rel[i][1];
            indeg[course]++;
        }
    }

    public void findAdj(int n, int[][] rel, List<List<Integer>> adj) {
        for(int i=1; i<=n+1; i++) {
            List<Integer> nums = new ArrayList<>();
            adj.add(nums);
        }

        for(int i=0; i<rel.length; i++) {
            int c = rel[i][0];
            adj.get(c).add(rel[i][1]);
        }
    }

    public int minimumSemesters(int n, int[][] relations) {
        int sem = 0;
        // count to track if all nodes are visited
        int count = 0; 
        int[] indeg = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        findIndegree(n, relations, indeg);
        findAdj(n, relations, adj);

        //insert the courses with indegree 0 to queue
        for(int i=1; i<=n; i++) {
            if(indeg[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        // if there are no nodes with indegree 0, it indicates a cycle
        if(q.size() == 0) {
            return -1;
        }

        // add 0 to count the semester
        q.add(0);

        while(q.size() > 0) {
            int c = q.remove();
            if( c == 0) {
                sem++;
                // add delimiter 0 only if there are unvisited nodes, else it will be an infinite loop
                if(q.size() > 0) {
                      q.add(0);
                }    
            }
            else {
                for(int neighbor : adj.get(c)) {
                    indeg[neighbor]--;
                    if(indeg[neighbor] == 0) {
                        q.add(neighbor);
                        count++;
                    }
                }
            }
        }
       return count < n ? -1 : sem;
    }
}