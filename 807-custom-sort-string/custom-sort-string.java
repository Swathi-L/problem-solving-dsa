class Solution {
    public String customSortString(String order, String s) {
      Map<Character, Integer> charMap = new HashMap<>();

      for(int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        charMap.put(c, charMap.getOrDefault(c, 0)+1);
      }

      StringBuilder result = new StringBuilder();

      for(int i=0; i<order.length(); i++) {
        char c = order.charAt(i);

        if(charMap.containsKey(c)) {
            for(int j=0; j<charMap.get(c); j++) {
                result.append(c);
            }
            charMap.remove(c);    
        }
      }

      charMap.forEach((key, val) -> {
        result.append(String.valueOf(key).repeat(val));
      });
    
        return result.toString();
    }
}