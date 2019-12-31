import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(0, 0, candidates, target, new ArrayList<>());
        return ret;
    }
    boolean combinationSum(int sum, int index, int[] candidates, int target, List<Integer> list) {
        if(sum == target) {
            ret.add(new ArrayList<>(list));
            return true;
        }else if (sum > target){
            return true;
        } else if(sum < target) {
            for(int i = index; i < candidates.length; i ++) {
                list.add(candidates[i]);
                boolean shouldStepOver = combinationSum(sum + candidates[i], i, candidates, target, list);
                list.remove(list.size() - 1);
                if(shouldStepOver){
                    break;
                }
            }
        }
        return false;
    }
}
// @lc code=end

