class Solution {
    public int findSpecialInteger(int[] arr) {
        int expectedCount = arr.length/4 + 1;

        int count=1;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            }
            else {
                count = 1;
            }
            if(count >= expectedCount) {
                return arr[i];
            }
        }
        return arr[0];
    }
}