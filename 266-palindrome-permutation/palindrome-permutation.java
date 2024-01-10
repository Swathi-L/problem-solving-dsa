class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> wordmap = new HashMap<>();

        // update count of each char in map
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(wordmap.containsKey(c)) {
                wordmap.put(c, wordmap.get(c)+1);
            }
            else {
                wordmap.put(c, 1);
            }
        }

        int oddCountChars = 0;

        for(Map.Entry<Character, Integer> m: wordmap.entrySet()) {
            if(m.getValue() % 2 == 1) {
                oddCountChars += 1;
            }
        }

        if(s.length() % 2 == 0 && oddCountChars != 0) {
            return false;
        }

        if(s.length() % 2 == 1 && oddCountChars != 1) {
            return false;
        }
        return true;
    }
}