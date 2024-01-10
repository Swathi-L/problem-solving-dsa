class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wptr = 0;
        int aptr = 0;
        int alen = abbr.length();
        int wlen = word.length();

        while(aptr < alen && wptr < wlen) {
            char ac = abbr.charAt(aptr);
            char wc = word.charAt(wptr);
            // System.out.println("Strt wptr: "+ wptr + " aptr: "+aptr);
            // System.out.println("wc: "+wc + " ac: "+ ac);
            if(ac >= 'a' && ac <= 'z') {
                if (ac != wc) {
                    System.out.println("ac: "+ac + " wc: "+wc);
                    return false;
                }
            }   
            else {

                int num = 0;
                // leading zero or empty substring
                if(ac - '0' == 0) {
                    // System.out.println("found 0 at " + aptr);
                    return false;
                }
        
                // find the count in between the abbr
                while(aptr < alen 
                    && abbr.charAt(aptr) >= '0' && abbr.charAt(aptr) <= '9') {
                    ac = abbr.charAt(aptr);
                    num = (num * 10) + (ac - '0');
                    aptr++;              
                }
                aptr--;
                // apple ap3
                // wptr=1
                // catches adjacent substrings abbreviated
                if(num + wptr > wlen) {
                    // System.out.println("num exceeds wlen; wptr: "+wptr+" aptr: " + aptr+ " num: "+num);
                    return false;
                }
                // System.out.println("num: "+num + " wptr: " + wptr+" aptr: " + aptr);
                // move the word ptr num times
                for(int i=1; i<num; i++) {
                    wptr++;
                }
            }
            aptr++;
            wptr++;
        }

        if(aptr == alen && wptr == wlen) {
            return true;
        }
        // System.out.println("END wptr: " + wptr+" aptr: " + aptr);
        return false;
    }
}