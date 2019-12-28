/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [][] rows = new int[9][10];
        int [][] cols = new int[9][10];
        int [][] boxes = new int[9][10];
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '0';
                if(rows[i][number] == 0) {
                    rows[i][number] ++;
                } else {
                    return false;
                }
                if(cols[j][number] == 0) {
                    cols[j][number] ++;
                } else {
                    return false;
                }
                if(boxes[i / 3 * 3 + j / 3][number] == 0) {
                    boxes[i / 3 * 3 + j / 3][number] ++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

