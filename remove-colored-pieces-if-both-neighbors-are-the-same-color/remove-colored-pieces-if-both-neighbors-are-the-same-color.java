class Solution {
    public boolean winnerOfGame(String colors) {
        int AliceTurns = 0, BobTurns = 0;

        for(int i=1; i<colors.length()-1; i++) {
            if(colors.charAt(i) == 'A' && colors.charAt(i-1) == 'A' && 
             colors.charAt(i+1) == 'A') {
                 AliceTurns += 1;
            }
            if(colors.charAt(i) == 'B' && colors.charAt(i-1) == 'B' && 
             colors.charAt(i+1) == 'B') {
                 BobTurns += 1;
            }
        }

        if(AliceTurns == 0 || (AliceTurns <= BobTurns)) {
            return false;
        }
        return true;
    }
}