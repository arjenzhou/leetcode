/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    boolean help(TreeNode root, long max, long min) {
        if(root == null){
            return true;
        } 
        if(root.val >= max || root.val <= min) {
            return false;
        }
        return help(root.left, root.val, min) && help(root.right, max, root.val);
    }
}
// @lc code=end

