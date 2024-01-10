class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(stk.size() > 0 && stk.peek() == c) {
                stk.pop();
            }
            else {
                stk.push(c);
            }
        }

        StringBuilder str = new StringBuilder();
        while(stk.size() > 0) {
            str.append(stk.pop());
        }
        return str.reverse().toString();
    }
}