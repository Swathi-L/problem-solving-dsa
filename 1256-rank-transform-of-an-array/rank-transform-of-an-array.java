class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet tset = new TreeSet();
        HashMap<Integer, Integer> nmap = new HashMap<>();

        for(int num : arr) {
            if(tset.contains(num)) {
                continue;
            }
            tset.add(num);
        }

        int rank = 1;
        while(tset.size() > 0) {
            int num = (Integer)tset.pollFirst();
            nmap.put(num, rank);
            rank++;
        }

        int res[] = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            res[i] = nmap.get(arr[i]);
        }
        return res;
    }
}