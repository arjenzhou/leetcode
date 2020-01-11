/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        if(n == -1) {
            return 1 / x;
        }
        double temp = myPow(x, n / 2);
        return temp * temp * myPow(x, n % 2);



        //n = MAX_VALUE 数组长度越界
        // if(n == 0) {
        //     return 1.00000;
        // }
        // boolean flag = n > 0 ? true : false;
        // n = n > 0 ? n : -n;

        // double [] dp = new double[n + 1];
        // dp[0] = 1.00000;
        // dp[1] = x;
        // for(int i = 0; i < dp.length; i ++ ) {
        //     dp[i] = dp[i / 2] * dp[(i + 1) / 2];
        // }
        // if(flag) {
        //     return dp[n];
        // } else {
        //     return 1/dp[n];
        // }
    }
}
// @lc code=end

