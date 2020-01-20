/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int number = 1;
        for(int i = 0; i < (1 + n) / 2; i ++) {
            for(int j = i; j < n - i; j ++) {
                res[i][j] = number ++;
            }
            for(int j = i + 1; j < n - i; j ++) {
                res[j][n - i - 1] = number ++;
            }
            for(int j = n - i - 2; j > i; j --) {
                res[n - i - 1][j] = number ++;
            }
            for(int j = n - i - 1; j > i; j --) {
                res[j][i] = number ++;
            }
        }
        return res;
    }
}
// @lc code=end

