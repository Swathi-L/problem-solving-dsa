class Solution {
    public int theMaximumAchievableX(int num, int t) {
        // x - 1 = num - 1; x = num 
        // x + 1 = num + 1; x = num
        // x + 1 = num - 1; x = num - 2
        // x - 1 = num + 1; x = num + 2

        int result = num;

        for(int i = 0; i<t; i++) {
            result += 2;
        } 
        return result;
    } 
}