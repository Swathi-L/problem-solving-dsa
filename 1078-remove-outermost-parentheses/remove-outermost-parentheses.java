class Solution {
    public String removeOuterParentheses(String s) {
        int brackets = 0;
        StringBuilder res = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                brackets++;
                if(brackets > 1) {
                    res.append(c);
                }
            }
            else {
                brackets--;
                 if(brackets > 0) {
                    res.append(c);
                }
            }
           
        }
        return res.toString();
    }
}