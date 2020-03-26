/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    curLen++;
                }
                max = max > curLen ? max : curLen;
            }
        }
        return max;
    }
}
// @lc code=end
