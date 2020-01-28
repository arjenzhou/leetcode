/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int [][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i  <grid.length; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < grid[0].length; j ++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < grid.length; i ++) {
            for(int j = 1; j < grid[0].length ; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length -1];
    }


    // Time Limit Exceeded

    // int res = 0;

    // public int minPathSum(int[][] grid) {
    //     for (int i = 0; i < grid.length; i++) {
    //         res += grid[i][grid[0].length - 1];
    //     }
    //     for (int j = 0; j < grid[0].length - 1; j++) {
    //         res += grid[0][j];
    //     }
    //     minPathSum(grid, 0, 0, grid[0][0]);
    //     return res;
    // }

    // void minPathSum(int[][] grid, int i, int j, int sum) {
    //     if (i == grid.length - 1 && j == grid[0].length - 1) {
    //         res = Math.min(sum, res);
    //     }
    //     if (i < grid.length - 1) {
    //         minPathSum(grid, i + 1, j, sum + grid[i + 1][j]);
    //     }
    //     if (j < grid[0].length - 1) {
    //         minPathSum(grid, i, j + 1, sum + grid[i][j + 1]);
    //     }
    // }
}
// @lc code=end
