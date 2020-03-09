/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return help(root, sum, 0);
    }
    boolean help(TreeNode root, int sum, int temp) {
        if(root.left == null && root.right == null) {
            if(sum == temp + root.val) {
                return true;
            } else {
                return false;
            }
        } else if (root.left == null) {
            return help(root.right, sum, temp + root.val);
        } else if(root.right == null) {
            return help(root.left, sum, temp + root.val);
        } else {
            return help(root.left, sum, temp + root.val) 
            || help(root.right, sum, temp + root.val);
        }
    }
}
// @lc code=end

