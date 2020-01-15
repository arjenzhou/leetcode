/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // if(nums.length == 1) {
        //     return true;
        // }
        // int [] dp = new int[nums.length];
        // dp[0] = nums[0];
        // if(dp[0] == 0) {
        //     return false;
        // }
        // for(int i = 1; i < nums.length; i ++) {
        //     dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        //     if(dp[i] == 0 && i != nums.length - 1) {
        //         return false;
        //     }
        // }
        // return dp[nums.length - 2] != 0;
        int max = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if(max > nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
// @lc code=end

