/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int fast = 2;
        for(; fast < nums.length; fast ++) {
            if(nums[fast] != nums[slow -1]) {
                slow ++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
// @lc code=end

