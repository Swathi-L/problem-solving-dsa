class Solution {
    // https://leetcode.com/problems/plates-between-candles/solutions/2057259/java-3-solutions-prefix-sum-binary-search-treemap
    
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];
        int[] leftWall = new int[n];
        int[] rightWall = new int[n];
        int[] res = new int[queries.length];
        int c = 0, left = -1, right = -1;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '*') {
                c++;
            }
            else{
                left = i;
            }
            prefixSum[i] = c;
            leftWall[i] = left;
        }

        for(int i=n-1; i>=0; i--) {
             if(s.charAt(i) == '|') {
                right = i;
            }
            rightWall[i] = right;
        }

        for(int i=0; i<queries.length; i++) {
            int strt = queries[i][0];
            int end = queries[i][1];
            
            int l = s.charAt(strt) == '*' ? rightWall[strt] : strt;
            int r = s.charAt(end) == '*' ? leftWall[end] : end;

            if(l == -1 || r == -1 || l > end || r > end || l == r) {
                res[i] = 0;
                continue;
            }

            res[i] = prefixSum[r] - prefixSum[l];
        }   
        return res;
    }
}