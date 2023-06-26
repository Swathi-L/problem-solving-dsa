class Solution {
    public int firstDigit(int n) {
        if(n < 10) {
            return n;
        }    
        
        while(n >= 10) {
            n = n / 10;
        }
        return n;
    } 
    
    public int gcd(int n1, int n2) {
        if(n2 > n1) {
            return gcd(n2, n1);
        }
        
        int rem = n1 % n2; 
        while(n2 > 1 && rem != 0) {
            n1 = n2;
            n2 = rem;
            rem = n1 % n2;
        }
        return n2 == 0 ? 1 : n2;
    }
    
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int gcd = gcd( firstDigit(nums[i]), nums[j] % 10);
                if(gcd == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}