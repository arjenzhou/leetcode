import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList(), nums, 0);
        return res;
    }
    void subsets(List<List<Integer>> res, List<Integer> list, int [] nums, int cur) {
        res.add(new ArrayList(list));
        for (int i = cur; i < nums.length; i++) {
            //i > cur 保证在新增数字时不被跳过
            if(i > cur && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsets(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

