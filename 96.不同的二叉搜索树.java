/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        /*
        G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n), f(i)=G(i−1)*G(n−i)
        => G(n)=G(0)*G(n−1)+G(1)*G(n−2)+...+G(n−1)*G(0)
        */

        /*
        g0 = 1
        g1 = 1
        g2 = g0 * g1 + g1 * g0 = 2
        g3 = g0 * g2 + g1 * g1 + g2 * g0 = 5
        g4 = g0 * g3 + g1 * g2 + g2 * g1 + g3 * g0 = 14
        */
        if(n <= 1) {
            return 1;
        }
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i ++) {
            for(int j = 0; j < i; j ++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
// @lc code=end

