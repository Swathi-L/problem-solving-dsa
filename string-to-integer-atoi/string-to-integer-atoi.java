class Solution {
    public int myAtoi(String s) {
        
        boolean neg = false;
        StringBuilder numStr = new StringBuilder();
        int idx = 0, len = s.length();

        // ignore leading space
        while(idx < len && s.charAt(idx) == ' ') {
            idx++;
        }

        // check positive or negative
        if(idx < len && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if(s.charAt(idx) == '-') {
                neg = true;
            }
            idx++;
        }

        // return 0 if no digits are present after the space / sign
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
        // if digits are larger than the Integer range, exception is thrown, then clamp the integer and return it
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

        // if number is within the integer range, just return it
        if(neg) {
            res = res * -1;
        }
        return res;
    }
}