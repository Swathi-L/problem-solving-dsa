class Solution {
    public String decodeString(String s) {
        Stack<String> charStk = new Stack<>();
        Stack<Integer> countStk = new Stack<>();

        StringBuilder curStr = new StringBuilder();
        int freq = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                freq = (freq * 10) + (ch - '0');
            }
            else if(Character.isLetter(ch)) {
                curStr.append(ch);
            } 
            else if(ch == '[') {
                charStk.push(curStr.toString());
                curStr = new StringBuilder();

                countStk.push(freq);
                freq = 0;
            }
            else {
                // closing bracket
                String str = charStk.pop();
                int c = countStk.pop();

                StringBuilder tmp = new StringBuilder();
                if(!str.equals("")) {
                    tmp.append(str);
                }
                for(int j=0; j<c; j++) {
                    tmp.append(curStr);
                }
                curStr = tmp;
            }
        }
        return curStr.toString();
    }
}