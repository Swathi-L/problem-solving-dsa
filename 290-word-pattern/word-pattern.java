class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternWordMap = new HashMap<>();
        Map<String, Character> wordCharMap = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            // check patternWord Map
            if(patternWordMap.containsKey(ch)) {
                if(!words[i].equals(patternWordMap.get(ch))) {
                    return false;
                }
            } else {
                patternWordMap.put(ch, words[i]);
            }

            // check wordChar map
            if(wordCharMap.containsKey(words[i])) {
                if(wordCharMap.get(words[i]) != ch) {
                    return false;
                }
            } else {
                wordCharMap.put(words[i], ch);
            }

        }
        return true;
    }
}