class Solution {
    public void dfs(int row, int col, char[][] grid){
        if(row<0 || row >= grid.length || col >= grid[0].length || col < 0) {
            return;
        }
        if(grid[row][col] == '0') {return; }
        grid[row][col] = '0';
        dfs(row, col+1, grid); //right
        dfs(row, col-1, grid); //left
        dfs(row-1, col, grid); //up
        dfs(row+1, col, grid); //down
    }

    public int numIslands(char[][] grid) {
       /*
Vertices: In the context of the "Number of Islands" problem, the       vertices can be thought of as the individual cells of the 2D grid. Each cell can be considered a node or a vertex.

Edges: The edges represent the connections between the cells in the 2D grid. In this problem, two adjacent cells (up, down, left, or right, but not diagonally) with a value of '1' are considered to be connected. Therefore, the edges represent the connections between adjacent land cells.
        */ 
        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}