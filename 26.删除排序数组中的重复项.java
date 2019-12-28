/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i ++;
            }                
            j ++;
        }
        return i + 1;
    }
}
// @lc code=end

