/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int temp1 = 1;
        int temp2 = 2;
        for(int i = 3; i <= n; i ++) {
            int temp = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp;
        }
        return temp2;
    }
}
// @lc code=end

