/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
         * // dp[n] = dp[n-1] + min(arr[n-1],arr[n])
         * 
         * dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j]
         * 
         * dp[i] 为每行第 i 个数的最小路径
         */
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int pre = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> rows = triangle.get(i);
            //note: height == width
            for (int j = 0; j <= i; j++) {
                // dp[i-1][j]
                cur = dp[j];
                if (j == 0) {
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    dp[j] = pre + rows.get(j);
                } else {
                    dp[j] = Math.min(cur, pre) + rows.get(j);
                }
                // dp[i-1][j - 1]
                pre = cur;
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            ret = Math.min(ret, dp[i]);
        }
        return ret;
    }
}
// @lc code=end
