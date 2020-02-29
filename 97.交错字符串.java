/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //s1 i, s2 j 能否 s3 i + j
        //dp[i][j] = (dp[i-1][j] && s3[i+j-1] == s1[i-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
        //s1 加上一个或者 s2 加上一个
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l1 + l2 != l3) {
            return false;
        }
        boolean [][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;

        //dp[i][0]
        for(int i = 1; i < l1 + 1; i ++) {
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }
        //dp[0][j]
        for(int j = 1; j < l2 + 1; j ++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        /*
        00 01 02 03 04 ...
        10 11 12 13 14
        20 21 22 ...
        30
        40
        ...
        */
        for(int i = 1; i < l1 + 1; i ++) {
            for(int j = 1; j < l2 + 1; j ++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) 
                || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[l1][l2];
    }
}
// @lc code=end

