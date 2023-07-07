class Solution {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> charSet = new HashMap<>();
        int max_count = 0;

        if(s.length() < 3){ return max_count; }

        for(int i=0; i<3; i++) {
            char c = s.charAt(i);
            if(!charSet.containsKey(c)) {
                charSet.put(c, 1);
            }else {
                int count = charSet.get(c);
                charSet.put(c, count+1);
            }
            
        }

        if(charSet.size() == 3) {max_count++; }

        int p1 = 0, p2 = 3;

        while(p2 < s.length()) {
            char p1_char = s.charAt(p1);
            int count = charSet.get(p1_char);
            
            if(count - 1 > 0) {
                 charSet.put(p1_char, count-1);
            } else {
                charSet.remove(p1_char);
            }
           
            char p2_char = s.charAt(p2);
            
            if(!charSet.containsKey(p2_char)) {
                charSet.put(p2_char, 1);
            } else {
                int p2_count = charSet.get(p2_char);
                charSet.put(p2_char, p2_count+1);
            }

            if(charSet.size() == 3) { max_count++; }
            p1++;
            p2++;
        }

        return max_count;
    }
}