/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    //????????????????????????
    int rows[];
    int hills[];
    int dales[];
    int n;
    List<List<String>> output = new ArrayList();
    // ??? row ? col ?? - queens[row] = col;
    int queens[];
  
    //???????
    public boolean isNotUnderAttack(int row, int col) {
    int res = rows[col] + hills[row - col + n] + dales[row + col];
      return res == 0;
    }
  
    public void placeQueen(int row, int col) {
      queens[row] = col;
      rows[col] = 1;
      hills[row - col + n] = 1;
      dales[row + col] = 1;
    }
  
    public void removeQueen(int row, int col) {
      queens[row] = 0;
      rows[col] = 0;
      hills[row - col + n] = 0;
      dales[row + col] = 0;
    }
  
    //??queens[], ???????? ...Q....
    public void addSolution() {
      List<String> solution = new ArrayList<String>();
      for (int i = 0; i < n; ++i) {
        int col = queens[i];
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < col; ++j) sb.append(".");
        sb.append("Q");
        for(int j = 0; j < n - col - 1; ++j) sb.append(".");
        solution.add(sb.toString());
      }
      output.add(solution);
    }

    //????????????n??????????????????
    public void backtrack(int row) {
      //?????????
      for (int col = 0; col < n; col++) {
        if (isNotUnderAttack(row, col)) {
          placeQueen(row, col);
          //???????????????
          if (row + 1 == n){
            addSolution();
          } else {
            backtrack(row + 1);
          }
          removeQueen(row, col);
        }
      }
    }
  
    public List<List<String>> solveNQueens(int n) {
      this.n = n;
      rows = new int[n];
      hills = new int[2 * n];
      dales = new int[2 * n];
      queens = new int[n];
  
      backtrack(0);
      return output;
    }
}
// @lc code=end

