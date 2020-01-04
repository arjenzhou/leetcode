/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int sum = 0;
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length -1];
        for(int i = 1; i < height.length; i ++ ) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        } 
        for(int i = height.length - 2; i >= 0; i --) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for(int i = 0; i < height.length; i ++ ) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(height[i] < min) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }
}
// @lc code=end

