class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        int w1, w2;
        
        StringBuilder res = new StringBuilder();

        for(w1=0, w2=0; w1<l1 && w2<l2; w1++,w2++) {
            res.append(word1.charAt(w1));
            res.append(word2.charAt(w2));
        }

        while(w1 < l1) {
            res.append(word1.charAt(w1));
            w1++;
        }

        while(w2 < l2) {
            res.append(word2.charAt(w2));
            w2++;
        }
        return res.toString();
    }
}