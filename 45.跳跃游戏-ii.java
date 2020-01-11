/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        }

        int start = 0;
        int count = 0;
        while(start < nums.length - 1) {
            start += dp[start];
            count ++;
        }
        return count;
    }
}
// @lc code=end

