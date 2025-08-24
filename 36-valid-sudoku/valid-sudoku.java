class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<9; i++){
            Set<Character> charSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            
            for(int j=0; j<9; j++) {
                char c = board[i][j];
                // row check
                if(c != '.' && charSet.contains(c)) {
                    return false;
                } else if(c != '.' && !charSet.contains(c)) {
                    charSet.add(c);
                }

                // col check
                c = board[j][i];
                if(c != '.' && colSet.contains(c)) {
                    return false;
                } else if(c != '.' && !colSet.contains(c)) {
                    colSet.add(c);
                }
            }
        }

        // 0 0, 1 0, 2 0, 3 0, 4 0...
        // 0 1  11 2 1 3 1 
        // r = 0 1 2, c = 0 1 2
        // r 0 1 2    c = 3 4 5, 6 7 8
        // r 3 4 5 

        for(int i = 0; i < 9; i += 3){
            for(int j=0; j<9; j+= 3) {
               Set<Character> gridSet = new HashSet<>(); 
                for(int r = i; r < i+3; r++) {
                    for(int c = j; c < j+3; c++) {
                        char ch = board[r][c];
                        if(ch != '.' && gridSet.contains(ch)) {
                            return false;
                        } else if(ch != '.' && !gridSet.contains(ch)) {
                            gridSet.add(ch);
                        }
                    }
                }
            }   
        }
        return true;
    }
}