/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    // public boolean isMatch(String s, String p) {
    //     return isMatch(s, p, 0, 0);
    // }

    // boolean isMatch(String s, String p, int sIndex, int pIndex) {
        
    //     if(s.length() == sIndex && p.length() == pIndex) {
    //         return true;
    //     } else if(s.length() == sIndex && p.charAt(pIndex) == '*') {
    //         return isMatch(s, p, sIndex, pIndex + 1);
    //     } else if(s.length() == sIndex || p.length() == pIndex) {
    //         return false;
    //     } else {
    //         if(p.charAt(pIndex) == '*') {
    //             boolean flag = false;
    //             for(int i = sIndex; i <= s.length(); i ++) {
    //                 flag = isMatch(s, p, i, pIndex + 1);
    //                 if(flag) {
    //                     break;
    //                 }
    //             }
    //             return flag;
    //         } else if(p.charAt(pIndex) == '?') {
    //             return isMatch(s, p, sIndex + 1, pIndex + 1);
    //         } else if(p.charAt(pIndex) == s.charAt(sIndex)) {
    //             return isMatch(s, p, sIndex + 1, pIndex + 1);
    //         } else if(p.charAt(pIndex) != s.charAt(sIndex)) {
    //             return false;
    //         }
    //     }
    //     return false;
    // }

    //dp(i, j)为 s 的前 i 个字符和 p 的前 j 个字符能否匹配
    public boolean isMatch(String s, String p) {
        //初始化
        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //p 后多个*的情况。s 前0个字符能否与 p 的前 i 个字符匹配上
        for(int i = 1; i <= p.length(); i ++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        //
        for(int i = 1; i <= s.length(); i ++) {
            for(int j = 1; j <= p.length(); j ++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
// @lc code=end

