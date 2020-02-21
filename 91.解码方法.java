/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        /*
         * dp[i] = dp[i - 1] + dp[i - 2]
         */
        int[] dp = new int[s.length()];
        // 考虑第一个字母
        if (s.charAt(0) == '0')
            return 0;
        else
            dp[0] = 1;

        if (s.length() == 1)
            return dp[0];

        // 考虑第二字母 11 ~ 99 except 20, 30, ... , 90 must >= 1
        // if x0 must [0, 1]
        if (s.charAt(1) != '0') {
            dp[1] = 1;
        }
        // if 11 ~ 26 except 20 must == 2
        // if 10 must == 1
        int temp = Integer.parseInt(s.substring(0, 2));
        if (temp <= 26 && temp >= 10){
            //take 10 into thinking
            dp[1] += 1;
        }
        for (int i = 2; i < s.length(); i++) {
            // xyz00, returns 0
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0')
                return 0;
            // xy{0} ≠ xy  xy{1} = xy
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];
            // x{27} ≠ x x{10} = x x{09} ≠ x x{11} = x
            if (10 <= Integer.parseInt(s.substring(i - 1, i + 1)) && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end
