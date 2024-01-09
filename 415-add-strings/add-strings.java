class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(p1 >= 0 && p2 >= 0) {
            int v1 = num1.charAt(p1) - '0';
            int v2 = num2.charAt(p2) - '0';

            int sum = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            res.append(sum);

            p1--;
            p2--;
        }

        while(p1 >= 0) {
            int v1 = num1.charAt(p1) - '0';
            int sum = (v1 + carry) % 10;
            carry = (v1 + carry) / 10;
            res.append(sum);
            p1--;
        }

         while(p2 >= 0) {
            int v2 = num2.charAt(p2) - '0';
            int sum = (v2 + carry) % 10;
            carry = (v2 + carry) / 10;
            res.append(sum);
            p2--;
        }

        if(carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
}