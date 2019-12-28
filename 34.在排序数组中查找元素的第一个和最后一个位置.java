/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                int start = -1, end = -1;
                for(int i = left; i <= right; i ++) {
                    if(nums[i] == target) {
                        if(start == -1) {
                            start = i;
                        }
                        end = i;
                    }
                }
                return new int[] {start, end};
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end

