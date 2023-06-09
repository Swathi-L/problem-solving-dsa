class Solution {
    public int myAtoi(String s) {
        
        boolean neg = false;
        StringBuilder numStr = new StringBuilder();
        int idx = 0, len = s.length();

        //ignore space
        while(idx < len && s.charAt(idx) == ' ') {
            idx++;
        }

        if(idx < len && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if(s.charAt(idx) == '-') {
                neg = true;
            }
            idx++;
        }

        if(idx < len && !(s.charAt(idx) >= '0' && s.charAt(idx) <= '9')) {
            return 0;
        }

        if(idx >= len) {
            return 0;
        }

        for( ;idx < len; idx++) {
            char c = s.charAt(idx);
            if(c >= '0' && c <= '9'){
                numStr.append(c);
            }
            else {
                break;
            }
        }

        int res;
        try{
             res = Integer.parseInt(numStr.toString());  
        }
        catch(Exception e) {
            if(neg) {
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.MAX_VALUE;
            }
        }

        if(neg) {
            res = res * -1;
        }
        return res;
    }
}