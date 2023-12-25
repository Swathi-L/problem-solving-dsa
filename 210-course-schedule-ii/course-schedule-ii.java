class Solution {
    public List<List<Integer>> fillAdj(int n, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            List<Integer> nums = new ArrayList<>();
            adj.add(nums);
        }

        for(int i=0; i<prereq.length; i++) {
            List<Integer> nums = adj.get(prereq[i][1]);
            nums.add(prereq[i][0]);
        }
        return adj;
    }

    public boolean dfs(int course, List<List<Integer>> adj, boolean[] visited, boolean[] inStack, Stack<Integer> out) {
        
        if(inStack[course]) {
            return true;
        }
        
        if(visited[course]) {
            return false;
        }

        inStack[course] = true;
        visited[course] = true;
        for(int neighbor : adj.get(course)) {
            if(dfs(neighbor, adj, visited, inStack, out)) {
                return true;
            }
        }
        out.push(course);
        inStack[course] = false;

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        Stack<Integer> out = new Stack<>();
        boolean[] inStack = new boolean[numCourses];

        adj = fillAdj(numCourses, prerequisites);

        for(int i=0; i<numCourses; i++) {
            if(dfs(i, adj, visited, inStack, out)) {
                return new int[0];
            }
        }

        int[] ordering = new int[numCourses];
        int i=0;
        while(out.size() > 0) {
            ordering[i++] = out.pop();
        }
        return ordering;
    }
}