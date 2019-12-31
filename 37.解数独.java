/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        boolean [][] isRowUsed = new boolean[9][10];
        boolean [][] isColUsed = new boolean[9][10];
        boolean [][] isBoxUsed = new boolean[9][10];
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                if(board[i][j] != '.') {
                    isRowUsed[i][board[i][j] - '0'] = true;
                    isColUsed[j][board[i][j] - '0'] = true;
                    isBoxUsed[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                }
            }
        }

        solveSudoku(0, 0, isRowUsed, isColUsed, isBoxUsed, board);
    }

    private boolean solveSudoku(int i, int j, boolean[][] isRowUsed, boolean[][] isColUsed, boolean [][] isBoxUsed,char [][] board) {
        if(j == 9) {
            if(i == 8) {
                return true;
            }
            i ++;
            j = 0;
        }
        if(board[i][j] != '.'){
            return solveSudoku(i, j + 1, isRowUsed, isColUsed, isBoxUsed, board);
        }

        for(int number = 1; number <= 9; number ++) {
            boolean isUsed = isRowUsed[i][number] || isColUsed[j][number] || isBoxUsed[i / 3 * 3 + j /3][number];
            if(!isUsed) {
                board[i][j] = (char)(number + '0');
                isRowUsed[i][number] = true;
                isColUsed[j][number] = true;
                isBoxUsed[i / 3 * 3 + j / 3][number] = true;
                //拦截，防止递归调用结束之后仍然回溯（填充之后被清掉
                if(solveSudoku(i, j + 1, isRowUsed, isColUsed, isBoxUsed, board)){
                    return true;
                }
                board[i][j] = '.';
                isRowUsed[i][number] = false;
                isColUsed[j][number] = false;
                isBoxUsed[i / 3 * 3 + j / 3][number] = false;
            }
        }
        return false;
    }
}
// @lc code=end

