class Solution {

    private void print(int[][] visited) {
        System.out.println("VISITED");

        for(int i=0; i<visited.length; i++) {
            for(int j=0; j<visited[i].length; j++) {
                System.out.print(visited[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int curIdx, int[][] visited) {

        if(r < 0 || r >= board.length || c < 0 || c >= board[r].length) {
            return false;
        }
        if(visited[r][c] == 1 || word.charAt(curIdx) != board[r][c]) {return false;}
        
        visited[r][c] = 1;

        if(curIdx >= word.length()-1) {return true;}

        boolean left, right, up, down;
    
        right = backtrack(board, word, r, c+1, curIdx+1, visited);
        if(right) {return true;}
            
        
        down = backtrack(board, word, r+1, c, curIdx+1, visited);
        if(down) {return true;}

        left = backtrack(board, word, r, c-1, curIdx+1, visited);
        if(left) {return true;}

        up = backtrack(board, word, r-1, c, curIdx+1, visited); 
        if(up) {return true;}

        // boolean result = (left || right) || (down || up);
        visited[r][c] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        
        boolean found = false;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    found = backtrack(board, word, i, j, 0, visited);
                    if(found) { 
                        return found;
                    }
                    else {
                        visited = new int[board.length][board[0].length]; 
                    }
                }
            }
        }
        return found;
			}
}