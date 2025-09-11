class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pFreqMap = new HashMap<>();

        List<Integer> indices = new ArrayList<>();
        int match = 0;
        int pLen = p.length();
        int sLen = s.length();

        for(int i=0; i<pLen; i++) {
            char c = p.charAt(i);
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<sLen; i++) {
            char c = s.charAt(i);

            if(pFreqMap.containsKey(c)) {
                int freq = pFreqMap.get(c);
                freq--;
                pFreqMap.put(c, freq);

                if(freq == 0) {
                    match++;
                }
            }

            if(i >= pLen) {
                char out = s.charAt(i - pLen);
                if(pFreqMap.containsKey(out)) {
                    int freq = pFreqMap.get(out);
                    freq++; 

                    pFreqMap.put(out, freq);

                    if(freq == 1) {
                        match--;
                    }
                }
            }

            if(match == pFreqMap.size()) {
                indices.add(i - pLen + 1);
            }
            System.out.println("i: " + i + " match: " + match + " char: " + s.charAt(i));
        }
        return indices;
    }
}