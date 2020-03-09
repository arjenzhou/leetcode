/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        help(root);
        return flag;
    }
    int help(TreeNode root) {
        if(!flag) {
            return 0;
        }
        if(root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        if(Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

