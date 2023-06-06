class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }

        char[] result = palindrome.toCharArray();
        boolean broken = false;
        
        for(int i=0; i<result.length/2; i++) {
            if(result[i] != 'a') {
                result[i] = 'a';
                broken = true;
                break;
            }
        }

        if(!broken) {
            result[result.length-1] = 'b';
        }
        
        return new String(result);
    }
}