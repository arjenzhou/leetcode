/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean search(int i, int j, int index, char[][] board, String word) {
        if (i == board.length || j == board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (board[i][j] == '.') {
            return false;
        }
        if (word.charAt(index) == board[i][j]) {
            if (index == word.length() - 1) {
                return true;
            } else {
                char t = board[i][j];
                board[i][j] = '.';
                boolean flag = search(i - 1, j, index + 1, board, word) 
                || search(i, j - 1, index + 1, board, word)
                || search(i, j + 1, index + 1, board, word) 
                || search(i + 1, j, index + 1, board, word);
                board[i][j] = t;
                return flag;
            }
        }
        return false;
    }
}
// @lc code=end
