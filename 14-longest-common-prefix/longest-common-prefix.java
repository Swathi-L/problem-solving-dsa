class Solution {
    public String longestCommonPrefix(String[] strs) {
       StringBuilder res = new StringBuilder();
       
       for(int i=0; i<strs[0].length(); i++) {
           for(int j=1; j<strs.length; j++) {
               if(strs[j].length() <= i || strs[j-1].length() <= i) {
                   return res.toString();
               }
               if(strs[j].charAt(i) != strs[j-1].charAt(i)) {
                   return res.toString();
               }
           }
           res.append(strs[0].charAt(i));
       }
       return res.toString(); 
    }
}