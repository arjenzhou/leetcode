import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ret.add(list);
                        left ++;
                        right --;
                    } else if(temp < target) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }
        return new ArrayList(new HashSet(ret));
    }
}
// @lc code=end

