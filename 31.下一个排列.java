import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i --) {
            //从后向前，若[i - 1] < [i]，则排序[i]及之后的数
            if(nums[i - 1] < nums[i]) {
                Arrays.sort(nums, i, nums.length);
                //找到排序数组第一个比[i - 1]大的数与其交换
                for(int j = i; j < nums.length; j ++ ) {
                    if(nums[j] > nums[i - 1]) {
                        int t = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = t;
                        return;
                    }
                }
            }
        }
        //若[i - 1] > [i]，即全为逆序，则对整个数组排序
        Arrays.sort(nums);
    }
}
// @lc code=end

