/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // 使用亦或运算判断结果正负
        boolean isPostive = (dividend ^ divisor) >= 0;
        // 负数作用域比正数大, 把正数转为负数处理
        dividend = dividend < 0 ? dividend : 0 - dividend;
        divisor = divisor < 0 ? divisor : 0 - divisor;

        int _divisor = divisor;
        int ans = 0;
        int multiple = 1;
        while (dividend <= _divisor) {
            if (dividend - divisor <= 0) {
                ans += multiple;
                dividend -= divisor;

                divisor += divisor;
                multiple += multiple;
            } else {
                divisor = _divisor;
                multiple = 1;
            }
        }
        return isPostive ? ans : 0 - ans;
    }
}
// @lc code=end

