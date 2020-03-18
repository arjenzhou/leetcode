/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        help(root, sum, 0, ret, new ArrayList());
        return ret;
    }
    void help(TreeNode root, int sum, int cur, List<List<Integer>> ret, List<Integer> list) {
        int temp = cur + root.val;
        list.add(root.val);
        if(temp == sum && root.left == null && root.right == null) {
            ret.add(new ArrayList(list));
        }
        if(root.left == null && root.right == null) {

        } else if(root.left == null) {
            help(root.right, sum, temp, ret, list);
        } else if(root.right == null) {
            help(root.left, sum, temp, ret, list);
        } else {
            help(root.left, sum, temp, ret, list);
            help(root.right, sum, temp, ret, list);
        }
        list.remove(list.size() - 1);
    }
}
// @lc code=end

