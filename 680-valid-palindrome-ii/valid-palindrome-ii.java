class Solution {
    public boolean checkPalindrome(String s) {
        int n = s.length();

        for(int i=0, j=n-1; i<j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        for(int i=0, j=n-1; i<j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                //remove either i or j and see if it's a palindrome
                return checkPalindrome(s.substring(i+1, j+1)) ||
                     checkPalindrome(s.substring(i, j));
            }
        }
        return true;
    }
}