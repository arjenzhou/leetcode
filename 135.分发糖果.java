/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
//https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int [] left = new int[length];
        int [] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < length; i ++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = length - 2; i >=0; i --) {
            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int count = 0;
        for(int i = 0; i < length; i ++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
// @lc code=end

