/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int mark = 1;
        if (x < 0) {
            mark = -1;
            //Integer.MAX_VALUE 是 2^31 - 1, Integer.MIN_VALUE 是 2^31。故 Integer.MIN_VALUE 取反会溢出，需要单独判断
            if(x == Integer.MIN_VALUE){
                return 0;
            }
            x = -x;
        }
        int res = 0;
        int length = 0;
        while (x != 0) {
            if (length == 9) {
                //在拼接最后一位时判断是否会溢出
                if (mark == 1) {
                    if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)) {
                        return 0;
                    }
                } else {
                    if (res > Integer.MIN_VALUE / 10 * -1 || (res == Integer.MIN_VALUE / 10 * -1 && x > Integer.MIN_VALUE % 10 * -1)){
                        return 0;
                    }
                }
            }
            res *= 10;
            res += x % 10;
            x /= 10;
            length++;
        }
        return mark * res;
    }
}
// @lc code=end
