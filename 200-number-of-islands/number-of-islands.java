class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    public int numIslands(char[][] grid) {
        
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
            || grid[r][c] == '0') {
             return;
        }

        // mark as visited
        grid[r][c] = '0';

        // explore all directions
        for(int[] dir : dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;

            dfs(grid, row, col);
        }
    }
}