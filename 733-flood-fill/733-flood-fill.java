class Solution {
    int[][] dirc = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    public void dfs(int row, int col, int[][] image,int initialColor, int newColor,boolean[][] vis){
        if(vis[row][col] == true)return;
        
        vis[row][col] = true;
        image[row][col] = newColor;
        
        for(int i = 0; i < 4; ++i){
            int nRow = row + dirc[i][0];
            int nCol = col + dirc[i][1];
            
            if(nRow < 0 || nCol < 0 || nRow >= image.length || nCol >= image[0].length) continue;
            
            if(image[nRow][nCol] != initialColor || image[nRow][nCol] == newColor) continue;
            
            dfs(nRow, nCol, image, initialColor, newColor, vis);
        }
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int[][] ans = new int[image.length][image[0].length];
        // for(int i = 0; i < image.length; ++i)
        //     for(int j = 0; j < image[0].length; ++j)
        //         ans[i][j] = 
        boolean[][] vis = new boolean[image.length][image[0].length];
        int initialColor = image[sr][sc];
        
        dfs(sr, sc, image, initialColor, color, vis);
        
        return image;
    }
}