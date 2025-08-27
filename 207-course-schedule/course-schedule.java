class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int count = 0;

        // build indegree array and adjacency list
        for(int[] pre : prerequisites) {
            inDegrees[pre[0]] += 1;

            if(adjList.get(pre[1]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                adjList.put(pre[1], list);
            }
            else {
                adjList.get(pre[1]).add(pre[0]);
            }
        }

        Queue<Integer> courseQ = new LinkedList<>();

        // add the first course with no dependency in queue
        for(int i=0; i<inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                courseQ.add(i);
                count++;
            }
        }

        while(!courseQ.isEmpty()) {
            int course = courseQ.remove();
            List<Integer> nextCourses = adjList.get(course);
            if(nextCourses == null) {
                continue;
            }

            for(int c : nextCourses){
                inDegrees[c] -= 1;
                if(inDegrees[c] == 0) {
                    courseQ.add(c);
                    count++;
                }
            }
        }

        if(count == numCourses) {
            return true;
        }
        return false;
    }
}