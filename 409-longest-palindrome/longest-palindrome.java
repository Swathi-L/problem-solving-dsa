class Solution {
    public int longestPalindrome(String s) {
        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();

        for(char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                maxLen += 2;
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }

        if(!charSet.isEmpty()) {
            maxLen += 1;
        }
        return maxLen;
    }
}