class Solution {
    private boolean isNice(String s, int strt, int end) {
        Set<Integer> uppercase = new HashSet<>();
        Set<Integer> lowercase = new HashSet<>();

        for(int i=strt; i <= end; i++) {
            char c = s.charAt(i);
            if(c >= 97) {
                if(!lowercase.contains(c)) {
                    lowercase.add(c - 'a');
                }
            } else {
                if(!uppercase.contains(c)) {
                    uppercase.add(c - 'A');
                }
            }
        }

        return uppercase.equals(lowercase);
    }
    
    public String longestNiceSubstring(String s) {
        String result = "";
        for(int i=0; i<s.length()-1; i++) {
            for(int j=i+1; j<s.length(); j++) {
                if(isNice(s, i, j)) {
                    if(j-i+1 > result.length()) {
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }
}