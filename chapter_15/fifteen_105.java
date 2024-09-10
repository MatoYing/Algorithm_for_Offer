package chapter_15;

/*
* 695. 岛屿的最大面积
* */
public class fifteen_105 {
    /**
     感觉像是第一次写非树的深度优先搜索，不难，得多做几道发现规律。
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                ans = Math.max(ans, dfs(i, k, grid));
            }
        }
        return ans;
    }

    public int dfs(int r, int c, int[][] grid) {
        int sum = 0;
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) {
            return sum;
        }
        sum += 1;
        // 走过的赋值为0，防止别的在走。一个1只能用一次（一个岛）。
        grid[r][c] = 0;
        sum += dfs(r + 1, c, grid);
        sum += dfs(r - 1, c, grid);
        sum += dfs(r, c + 1, grid);
        sum += dfs(r, c - 1, grid);
        return sum;
    }
}
