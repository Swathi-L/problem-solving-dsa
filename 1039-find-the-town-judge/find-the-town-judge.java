class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdeg = new int[n+1];
        int[] indeg = new int[n+1];

        for(int i=0; i<trust.length; i++) {
            outdeg[trust[i][0]] += 1;
            indeg[trust[i][1]] += 1;
        }

        boolean judge = false;
        int judgeId = -1;
        for(int i=1; i<=n; i++) {
            if(outdeg[i] == 0) {
                if(judge) {
                    return -1;
                }
                judge = true;
                judgeId = i;
            }
        }

        if(judgeId != -1 && indeg[judgeId] == n-1) {
            return judgeId;
        }
        return -1;
    }
}