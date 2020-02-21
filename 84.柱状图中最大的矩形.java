/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
//https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/084zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-6westb/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i ++) {
            //若高度下降了，则计算之前所有可能的面积
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);
            }
            stack.push(i);
        }
        //栈中剩余的数
        while(stack.peek() != -1) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }
        return maxArea;
    }
}
// @lc code=end

