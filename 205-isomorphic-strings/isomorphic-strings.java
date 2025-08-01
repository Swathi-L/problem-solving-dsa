class Solution {
    private boolean helper(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            if(charMap.containsKey(sChar)) {
                if(charMap.get(sChar) != t.charAt(i)) {
                    return false;
                }
            } else {
                charMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }
}