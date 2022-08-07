class Solution {
    public void dfs(int[][] image, int sr, int sc, int startColor, int newColor){
        
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
            return;
        }
        
        if(image[sr][sc] != startColor)return;
        
        image[sr][sc] = newColor;
        
        dfs(image, sr+1, sc, startColor, newColor);
        dfs(image, sr-1, sc, startColor, newColor);
        dfs(image, sr, sc+1, startColor, newColor);
        dfs(image, sr, sc-1, startColor, newColor);
        
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}