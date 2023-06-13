class Solution {
    private int compare(int n1, int n2) {
        if(n1 == n2) {
            return 0;
        }
        int[] nums = new int[2];
        nums[0] = n1;
        nums[1] = n2;
        String s1 = intArrayToString(nums);
        
        nums[0] = n2;
        nums[1] = n1;
        String s2 = intArrayToString(nums);

        // 3, 30 -> returns -1, expected 1
        // String s1 = Integer.toString(n1);
        // String s2 = Integer.toString(n2);

        return s1.compareTo(s2);
    }

    public String intArrayToString(int[] nums) {
        StringBuilder result = new StringBuilder();

        for(int num : nums) {
            result.append(num);
        }
        return result.toString();
    }

    private boolean checkZero(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public String largestNumber(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length-1; j++) {
                if(compare(nums[j], nums[j+1]) < 0) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        if(checkZero(nums)) {
            return "0";
        }
        return intArrayToString(nums);
    }
}