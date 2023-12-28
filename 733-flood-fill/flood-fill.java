class Solution {
    public void dfs(int[][] image, int sr, int sc, int[][] visited, int start_color, int color) {
        // check matrix boundaries
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
  
        // stop exploring the path once the cell has non conforming color
        // this does not take care of already visited cell if start color and color are same
        if(image[sr][sc] != start_color) {
            return;
        }
        
        if(visited[sr][sc] == 1) {
            return;
        }

        visited[sr][sc] = 1; 
        image[sr][sc] = color; 

        dfs(image, sr, sc+1, visited, start_color, color); // right
        dfs(image, sr, sc-1, visited, start_color, color); // left
        dfs(image, sr-1, sc, visited, start_color, color); // up
        dfs(image, sr+1, sc, visited, start_color, color); // down

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];

        dfs(image, sr, sc, visited, image[sr][sc], color);
        return image;
    }
}