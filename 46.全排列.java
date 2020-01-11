import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0){
            return ret;
        }
        int [] visited = new int[nums.length];
        permute(0, nums, visited, ret, new ArrayList());
        return ret;
    }

    void permute(int count, int [] nums, int [] visited, List<List<Integer>> ret, List<Integer> list) {
        if(count == nums.length) {
            ret.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                permute(count + 1, nums, visited, ret, list);
                list.remove(list.size() - 1);
                visited[i] = 0;
            } else {
                continue;
            }
        }
    }
}
// @lc code=end

