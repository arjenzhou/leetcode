/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while(x < matrix.length && y >= 0) {
            int temp = matrix[x][y];
            if(temp == target){
                return true;
            } else if(temp > target) {
                y--;
            } else {
                x ++;
            }
        }
        return false;
    }
}
// @lc code=end

