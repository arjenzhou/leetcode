import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList(), nums, 0);
        return res;
    }
    void subsets(List<List<Integer>> res, List<Integer> list, int [] nums, int cur) {
        res.add(new ArrayList(list));
        for (int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

