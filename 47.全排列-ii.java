/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        //3303
        Arrays.sort(nums);
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
            //前一个数没访问过，且他俩相等，则不访问该数（会在别的分支中访问到）
            if(i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)
                continue;
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

