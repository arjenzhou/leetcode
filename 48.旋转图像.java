/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < length / 2; i ++) {
            for(int j = i; j < length - i - 1; j ++) {
                int t1 = matrix[i][j];
                int t2 = matrix[j][length - i - 1];
                int t3 = matrix[length - i - 1][length - j - 1];
                int t4 = matrix[length - j - 1][i];

                matrix[j][length - i - 1] = t1;
                matrix[length - i - 1][length - j - 1] = t2;
                matrix[length - j - 1][i] = t3;
                matrix[i][j] = t4;
            }
        }
    }
}
// @lc code=end

