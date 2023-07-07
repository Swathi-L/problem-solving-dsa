class Solution {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int max_count = 0;

        if(s.length() < 3){ return max_count; }

        for(int i=0; i<3; i++) {
            char c = s.charAt(i);
            if(!charCount.containsKey(c)) {
                charCount.put(c, 1);
            }else {
                int count = charCount.get(c);
                charCount.put(c, count+1);
            }
            
        }

        if(charCount.size() == 3) {max_count++; }

        int p1 = 0, p2 = 3;

        while(p2 < s.length()) {
            char p1_char = s.charAt(p1);
            int p1_count = charCount.get(p1_char);
            
            if(p1_count - 1 > 0) {
                 charCount.put(p1_char, p1_count-1);
            } else {
                charCount.remove(p1_char);
            }
           
            char p2_char = s.charAt(p2);
            
            if(!charCount.containsKey(p2_char)) {
                charCount.put(p2_char, 1);
            } else {
                int p2_count = charCount.get(p2_char);
                charCount.put(p2_char, p2_count+1);
            }

            if(charCount.size() == 3) { max_count++; }
            p1++;
            p2++;
        }

        return max_count;
    }
}