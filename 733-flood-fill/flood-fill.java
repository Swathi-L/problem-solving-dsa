class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, image[sr][sc], color);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int oldColor, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || image[sr][sc] != oldColor || oldColor == color) {
            return image;
        }
        image[sr][sc] = color;

        // right
        dfs(image, sr, sc+1, oldColor, color);
        // left
        dfs(image, sr, sc-1, oldColor, color);
        // up
        dfs(image, sr-1, sc, oldColor, color);
        // down
        dfs(image, sr+1, sc, oldColor, color);
        return image;
    }
}