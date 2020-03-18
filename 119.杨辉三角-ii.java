import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        if(rowIndex == 0) {
            return first;
        }
        first.add(1);
        if(rowIndex == 1) {
            return first;
        }
        List<Integer> second = null;
        for(int i = 2; i <= rowIndex; i ++) {
            second = new ArrayList<>();
            for(int j = 0; j <= i; j ++) {
                if(j == 0 || j == i) {
                    second.add(1);
                } else {
                    second.add(first.get(j - 1) + first.get(j));
                }
            }
            first = new ArrayList(second);
        }
        return second;
    }
}
// @lc code=end
