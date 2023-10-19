class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // graph bfs
        // visited set of rooms
        Set<Integer> visited = new HashSet<>();
        // queue to store keys
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<rooms.get(0).size(); i++) {
            queue.add(rooms.get(0).get(i));
            visited.add(0);
        }

        while(queue.size() > 0) {
            int room = queue.remove();
            
            for(int i=0; i<rooms.get(room).size(); i++) {
                int r = rooms.get(room).get(i);
                if(!visited.contains(r)) {
                    queue.add(r);
                }
            }
            visited.add(room);
           
        }
        return visited.size() == rooms.size();
    }
}