class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cur = 1, idx=0;
        int len = arr.length;
        List<Integer> missing = new ArrayList<>();

        if(arr[idx] != 1) {
            while(cur != arr[0]) {
                missing.add(cur);
                cur++;
            }
            idx++;
        }
        
        for(int i=idx; i<len; i++) {
            if( i>0 && arr[i] != arr[i-1] + 1 ) {
               cur = arr[i-1] + 1;
               while(cur != arr[i]) {
                   missing.add(cur);
                   cur++;
               }    
            }
        }

        if(k > missing.size()) {
            return arr[len-1] + k - missing.size();
        }
        return missing.get(k-1);
    }
}