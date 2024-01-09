class Solution {
    public int compare(String w1, String w2, int[] orderVal) {
        if(w1.equals(w2)) {
            System.out.println(w1 + " " + w2 + " equal");
            return 0;
        }
        int p1 = 0, p2 = 0;
        while( p1 < w1.length() && p2 < w2.length()) {
            Character c1 = w1.charAt(p1);
            Character c2 = w2.charAt(p2);

            if(c1 == c2) {
                p1++;
                p2++;
            }
            else {
                int v1 = c1 - 97;
                int v2 = c2 - 97;
        
                return orderVal[v1] - orderVal[v2];
            }
        }
        if(p1 < w1.length()) {
            return 1;
        }
        return -1;
    }

    public int[] findOrderVal(String order) {
        int[] result = new int[26];

        for(int i=0; i<26; i++) {
            Character c = order.charAt(i);
            result[c - 97] = i;
        }
        return result;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderVal = new int[26];

        orderVal = findOrderVal(order);

        for(int i=1; i<words.length; i++) {
            System.out.println(compare(words[i-1], words[i], orderVal));
            if(compare(words[i-1], words[i], orderVal) > 0) {
                return false;
            }
        }
        return true;
    }
}