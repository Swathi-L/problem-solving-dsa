class Solution {
    public int countFresh(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 1) {
                    count++;
                }
        }
        return count;
    }

    public void markRotten(int[][] grid, List<Integer> rows, List<Integer> cols) {
        for(int i=0; i<rows.size(); i++) {
            int r = rows.get(i);
            int c = cols.get(i);
            grid[r][c] = 2;
        }
    }

    // checks if the fresh orange will rotten, if yes, returns true else returns false. 
    public boolean checkRotten(int[][] grid, int row, int col) {
        // check if up is rotten
        if(row > 0 && grid[row-1][col] == 2) {
            return true;
        }
        // check down
        if(row < grid.length-1 && grid[row+1][col] == 2) {
            return true;
        }
        //check left
        if(col > 0 && grid[row][col-1] == 2) {
            return true;
        }
        // check right
        if(col < grid[0].length-1 && grid[row][col+1] == 2) {
            return true;
        }
        return false;
    }

    // marks rotten oranges and returns true if there are new rotten oranges
    public boolean markRotten(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                int cell = grid[i][j];
                if(cell == 1) {
                    if(checkRotten(grid, i, j)) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
        }

        if(rows.size() > 0) {
            markRotten(grid, rows, cols);
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        
        boolean rotten = true;
        int minute = 0;

        while(rotten) {
            rotten = markRotten(grid);
            if(rotten) {
                minute++;
            }
        }
        System.out.println(minute);
       int fresh = countFresh(grid);
       if(fresh > 0) {
           return -1;
       }
       return minute;
    }
}