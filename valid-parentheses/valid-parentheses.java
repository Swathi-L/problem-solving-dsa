class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                brackets.push(c);
            }
            else {
                if(brackets.size() == 0) {
                    return false;
                }
                char popc = brackets.pop();
                if(c == ')' && popc != '(' ) {
                    return false;
                }
                if(c == '}' && popc != '{' ) {
                    return false;
                }
                if(c == ']' && popc != '[' ) {
                    return false;
                }
            }
        }

        if(brackets.size() > 0) {
            return false;
        }
        return true;
    }
}