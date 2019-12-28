import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, 0, 0, "");
        return list;
    }
    
    private void generateParenthesis(int n, int left, int right, String str) {
        if(right == n) {
            list.add(str);
            return;
        }
        if(left < n) {
            generateParenthesis(n, left + 1, right, str + "(");
            if(left > right) {
                generateParenthesis(n, left, right + 1, str + ")");
            }
        }
        if(left == n) {
            generateParenthesis(n, left, right + 1, str + ")");
        }
    }
}
// @lc code=end

