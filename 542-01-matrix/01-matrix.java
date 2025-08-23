class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
                else {
                    q.add(new int[]{i, j});
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()) {

            int k = q.size();
            for(int i=0; i<k; i++) {
                int[] rc = q.remove();

                for(int j=0; j<dirs.length; j++) {
                    int r = dirs[j][0] + rc[0];
                    int c = dirs[j][1] + rc[1];
                    
                    if(r >= 0 && c >= 0 && r < mat.length
                        && c < mat[0].length) {
                    
                    if(mat[r][c] == -1) {
                        q.add(new int[]{r, c});
                        mat[r][c] = dist;
                    }
                }
            }
        }
        dist++;
       }
       return mat;
    }
}