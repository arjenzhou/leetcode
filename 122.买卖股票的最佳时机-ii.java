/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int pre = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int temp = prices[i] - pre;
            if (temp > 0) {
                profit += temp;
            }
            pre = prices[i];
        }
        return profit;
    }
}
// @lc code=end
