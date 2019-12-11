/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = min(height[0] ,height[height.length - 1]) * (height.length - 1);
        int left = 0, right = height.length - 1;
        while (left < right) {
            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
            int temp = min(height[left], height[right]) * (right - left);
            max = max > temp ? max : temp;
        }
        return max;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
// @lc code=end

