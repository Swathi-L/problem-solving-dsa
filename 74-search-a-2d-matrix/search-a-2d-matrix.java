class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;

        // binary search
        int mid;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            mid = left + (right - left)/2;
            int row = mid / cols;
            int col = mid % cols;

            if(matrix[row][col] == target) {
                return true;
            }

            if(matrix[row][col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}