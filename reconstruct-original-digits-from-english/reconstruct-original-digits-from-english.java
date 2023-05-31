class Solution {
    // find the unique character for each digit
    public String originalDigits(String s) {
        int[] inputCount = new int[26];
        int[] output = new int[10];

        for(int i=0; i<s.length(); i++) {
            inputCount[s.charAt(i)-'a'] = inputCount[s.charAt(i)-'a']+1;
        }

        output[0] = inputCount['z' - 'a']; //"z" ero
        output[2] = inputCount['w' - 'a']; //t "w" o
        output[4] = inputCount['u' - 'a']; //fo "u" r
        output[6] = inputCount['x' - 'a']; //si "x"
        output[8] = inputCount['g' - 'a']; //ei "g" ht

        output[3] =  inputCount['h' - 'a'] - output[8]; // t "h" ree
        output[5] =  inputCount['f' - 'a'] - output[4]; // "f" ive
        output[7] =  inputCount['s'-'a'] - output[6];         // "s"even
        output[9] =  inputCount['i'-'a']-output[6]-output[8]-output[5];   // nine
        output[1] =  inputCount['o'-'a'] - output[0] - output[2] - output[4];  // one

        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<output.length; i++) {
            if(output[i] > 0) {
                for(int j=0; j<output[i]; j++) {
                    result.append(i);
                }
            }
        }
        return result.toString();
    }
}