import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minius = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {                
                int t = nums[i] + nums[left] + nums[right];
                int tminius = Math.abs(t - target);
                if(tminius < minius) {
                    minius = tminius;
                    res = t;
                }
                if(t == target) {
                    return res;
                }
                if(t < target) {
                    left ++;
                }
                if(t > target) {
                    right --;
                }

            }
        }
        return res;
    }
}
// @lc code=end

