import java.util.regex.*;

class Solution {

     private boolean checkIPv4(String input) {
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[1-9]|[1-9][0-9]|1[0-9][0-9]|0)\\.(25[0-5]|2[0-4][0-9]|[1-9]|[1-9][0-9]|1[0-9][0-9]|0)\\.(25[0-5]|2[0-4][0-9]|[1-9]|[1-9][0-9]|1[0-9][0-9]|0)\\.(25[0-5]|2[0-4][0-9]|[1-9]|[1-9][0-9]|1[0-9][0-9]|0)$");
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
     }

    private boolean checkIPv6(String input) {
        Pattern pattern = Pattern.compile("^([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]{1,4}):([0-9a-fA-F]){1,4}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public String validIPAddress(String queryIP) {
        
        boolean ipv4 = checkIPv4(queryIP);
        if(ipv4) {return "IPv4";}

        boolean ipv6 = checkIPv6(queryIP);
        if(ipv6) {return "IPv6";}

        return "Neither";
        
    }
}