/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // int res = Integer.MIN_VALUE;
        // for (int i = 0; i < prices.length; i++) {
        // for (int j = i; j < prices.length; j++) {
        // int temp = prices[j] - prices[i];
        // if(temp > 0) {
        // res = temp > res ? temp : res;
        // }
        // }
        // }
        // return res == Integer.MIN_VALUE ? 0 : res;
        int min = Integer.MAX_VALUE;
        int maxProfix = 0;
        for (int i = 0; i < prices.length; i++) {
            min = min < prices[i] ? min : prices[i];
            int t = prices[i] - min;
            maxProfix = maxProfix > t ? maxProfix : t;
        }
        return maxProfix;
    }
}
// @lc code=end
