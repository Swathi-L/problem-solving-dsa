class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length;

        int[][] product = new int[m][n];
        
        for(int r=0; r<mat1.length; r++) {
            for(int c=0; c<mat2[0].length; c++) {
                for(int k=0; k<mat1[0].length; k++) {
                    product[r][c] += mat1[r][k] * mat2[k][c];
                }
            }
        }
        return product;
    }
}