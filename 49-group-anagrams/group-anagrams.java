class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();

        for(String str : strs) {
            char[] strArray =  str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if(stringListMap.containsKey(sortedStr)) {
                stringListMap.get(sortedStr).add(str);
            } else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                stringListMap.put(sortedStr, strList);
            }
        }
        return new ArrayList<>(stringListMap.values());
    }
}