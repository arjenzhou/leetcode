import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList(), n, k, 1);
        return res;
    }
    void combine(List<List<Integer>> res, List<Integer> list, int n, int k, int cur) {
        if(list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = cur; i <= n; i ++) {
            list.add(i);
            combine(res, list, n, k, i + 1);
            list.remove(list.get(list.size() - 1));
        }
    }
}
// @lc code=end

