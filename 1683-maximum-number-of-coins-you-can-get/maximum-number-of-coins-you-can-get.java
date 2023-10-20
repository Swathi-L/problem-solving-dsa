class Solution {
    public void reverse(int[] piles) {
        int n = piles.length;
        for(int i=0; i<n/2; i++) {
            int t = piles[n-i-1];
            piles[n-i-1] = piles[i];
            piles[i] = t;
        }
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        reverse(piles);
        int times = piles.length / 3;
        int max = 0;
        for(int i = 0,j=1; i<times; i++) {
            max += piles[j];
            j+=2;
        }
        return max;
    }
    
}
