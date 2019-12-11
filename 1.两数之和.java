import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value;
            if(map.containsKey(nums[i]) && i != (value = map.get(nums[i]))){
                return new int[]{
                    i, value
                };
            }
        }
        return null;
    }
}
// @lc code=end

