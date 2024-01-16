class SparseVector {
    
    Map<Integer, Integer> mat;
    SparseVector(int[] nums) {
        mat = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                mat.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int product=0;
        
        for(Map.Entry<Integer, Integer> m : vec.mat.entrySet()) {
            int k1 = m.getKey();

            if(mat.containsKey(k1)) {
                product += (m.getValue() * mat.get(k1));
            }
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);