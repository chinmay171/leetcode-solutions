class Solution {
    int[][] dir = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
    public void dfs(int[][] mat, int r, int c, int oldC, int newC){
        if(mat[r][c] == newC) return;
        mat[r][c] = newC;
        for(int i = 0; i < 4; ++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length)
                continue;
            if(mat[nr][nc] != oldC) continue;

            dfs(mat, nr, nc, oldC, newC);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}