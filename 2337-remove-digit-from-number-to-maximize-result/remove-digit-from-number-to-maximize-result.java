class Solution {
    public String removeDigit(String number, char digit) {
        String maxStr = "";

        for(int i=0; i<number.length(); i++) {
            if(number.charAt(i) == digit) {
                String substr = number.substring(0,i) + number.substring(i+1);
                
                if(substr.compareTo(maxStr) > 0) {
                    maxStr = substr;
                }
            }
        }
        return maxStr;
    }
}