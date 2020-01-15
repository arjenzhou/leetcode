import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0) {
            return ret;
        }
        boolean [][] isVisited = new boolean[matrix.length][matrix[0].length];
        int min = Math.min((1 + matrix.length) / 2, (1 + matrix[0].length) / 2);
        for(int i = 0; i < min; i ++) {
            for(int j = i; j < matrix[0].length - i; j ++) {
                if(isVisited[i][j] == false) {
                    isVisited[i][j] = true;
                    ret.add(matrix[i][j]);
                }
            }
            for(int j = i + 1; j < matrix.length - i; j ++){
                if(isVisited[j][matrix[0].length - i - 1] == false) {
                    isVisited[j][matrix[0].length - i - 1] = true;
                    ret.add(matrix[j][matrix[0].length - i - 1]);
                }
            }
            for(int j = matrix[0].length - i - 1 - 1; j > i; j --) {
                if(isVisited[matrix.length - i - 1][j] == false) {
                    isVisited[matrix.length - i - 1][j] = true;
                    ret.add(matrix[matrix.length - i - 1][j]);
                }
            }
            for(int j = matrix.length - i - 1; j > i; j --) {
                if(isVisited[j][i] == false) {
                    isVisited[j][i] = true;
                    ret.add(matrix[j][i]);
                }
            }
        }
        return ret;
    }
}
// @lc code=end

