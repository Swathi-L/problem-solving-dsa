class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for(int[] interval : intervals) {
            
            if(endTimes.isEmpty()) {
                endTimes.add(interval[1]);
            }
            else {
                int endtime = endTimes.peek();
                
                if(endtime <= interval[0]) {
                    endTimes.poll();
                }
                endTimes.add(interval[1]);
            }
        }
        return endTimes.size();
    }
}