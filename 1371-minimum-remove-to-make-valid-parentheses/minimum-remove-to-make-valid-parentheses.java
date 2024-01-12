class Solution {
    public String minRemoveToMakeValid(String s) {
        int slen = s.length();
        int[] valid = new int[slen];

        for(int i=0; i<slen; i++) {
            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z') {
                valid[i] = 1;
            }
            else if(c == ')') {
                // check if there are matching open bracket before it

                for(int j=i-1; j>=0; j--) {
                    if(valid[j] == 0 && s.charAt(j) == '(') {
                        valid[j] = 1;
                        valid[i] = 1;
                        break;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i=0; i<slen; i++) {
            if(valid[i] == 1) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}