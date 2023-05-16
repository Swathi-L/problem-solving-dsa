class Solution {
    List<String> result;
    private void backtrack(String cur, int openN, int closeN) {
        if(openN == 0 && closeN == 0) {
            result.add(cur);
            return;
        }

        if(openN > 0) {
            backtrack(cur + "(", openN-1, closeN);
        }
        if(openN < closeN) {
            backtrack(cur + ")", openN, closeN-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack("(", n-1, n);  
        return result;  
    }
}