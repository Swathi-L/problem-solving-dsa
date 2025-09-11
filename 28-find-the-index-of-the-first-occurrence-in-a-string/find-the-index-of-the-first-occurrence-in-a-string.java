class Solution {
    public int strStr(String haystack, String needle) {
       int hlen = haystack.length();
       int nlen = needle.length();
       for(int i=0; i<=hlen - nlen; i++) {
            char c = haystack.charAt(i);
            
            if(isStrStr(haystack, needle, i)) {
                return i;
            }
       }
       return -1;
    }

    private boolean isStrStr(String haystack, String needle, int idx) {

        for(int i=0; i<needle.length(); i++) {
            if(haystack.charAt(idx++) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}