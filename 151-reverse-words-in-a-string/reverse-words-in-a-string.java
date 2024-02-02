class Solution {
    public String reverseWords(String s) {
        
        Stack<StringBuilder> wordStk = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                 StringBuilder str = new StringBuilder();
                 for(; i<n && s.charAt(i) != ' '; i++) {
                     str.append(s.charAt(i));
                 }
                wordStk.push(str);
            }
        }

        StringBuilder result = new StringBuilder();
        while(wordStk.size() > 0) {
            result.append(wordStk.pop());
            result.append(" ");
        }
       return result.toString().substring(0, result.length()-1);
    }
}