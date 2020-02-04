/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] é¢œè‰²åˆ†ç±»
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int cur = 0;
        while(cur <= r) {
            if(nums[cur] == 2) {
                swap(nums, cur, r);
                r --;
            } else if(nums[cur] == 0) {
                swap(nums, l, cur);
                l ++;
                cur ++;
            } else {
                cur ++;
            }
        }
    }

    void swap(int [] nums, int l , int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// @lc code=end

