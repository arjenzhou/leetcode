/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(left == right) {
                if(nums[mid] < target) {
                    return mid + 1;
                } else if (nums[mid] > target) {
                    return mid;
                }
            }
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
// @lc code=end

