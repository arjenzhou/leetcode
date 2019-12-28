/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length <= 0) {
            return nums.length;
        }
        int left = -1, right = 0;
        while(right < nums.length) {
            if(nums[right] != val) {
                nums[left + 1] = nums[right];
                left ++;
            }
            right ++;
        }
        return left + 1;
    }
}
// @lc code=end

