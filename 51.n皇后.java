/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    //列是否被使用
    int cols[];
    int hills[];
    int dales[];
    int n;
    List<List<String>> output = new ArrayList();
    // 记录每行皇后所在列的位置 - queens[row] = col;
    int queens[];
  
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
  
    //根据queens[]的数据, 填充每行的结果，如： ...Q....
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

    //若存在某行不能填充，则回溯到底，该结果不会存在于结果集中
    public void backtrack(int row) {
      //按行填充
      for (int col = 0; col < n; col++) {
        if (isNotUnderAttack(row, col)) {
          placeQueen(row, col);
          //得到一个结果后，才将此结果按行填充到结果集中
          if (row + 1 == n){
            addSolution();
            //一行完成后（得到一个Q），直接进入下一行
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

