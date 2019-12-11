import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++) {
            //对于排序后的数组，若第一个值大于0，那么后面一定没有合适的结果
            if(nums[i] > 0) {
                break;
            }
            //若与上一个基准值相同，直接跳过避免出现重复
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                //若left与上一个数相同，跳过
                if(left > i + 1 && nums[left - 1] == nums[left]){
                    left ++;
                    continue;
                }
                //若right与后一个数相同，跳过
                if(right < nums.length - 1 && nums[right + 1] == nums[right]){
                    right --;
                    continue;
                }
                //符合情况，添加到结果中
                if(nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);
                    left ++;
                    right --;
                } else if(nums[left] + nums[right] < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return ret;
    }
}
// @lc code=end

