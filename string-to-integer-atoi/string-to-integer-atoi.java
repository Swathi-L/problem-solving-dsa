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

        long res = 0;
        String numString = numStr.toString();
        int j=0;
        for(int i=numString.length()-1; i>=0; i--) {
            res += (numString.charAt(i) -  '0') * Math.pow(10,j);
            j++;
        }
        
        // negate the integer if input has '-'
        if(neg) {
            res = res * -1;
        }

        // return 2^31 - 1 if input is gt 2^31 - 1
        if(res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        // return -2^31 if input < -2^31
        if(res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
            
        return (int)res;
    }
}