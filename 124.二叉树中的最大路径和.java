/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        help(root);
        return max;
    }

    int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);
        int temp = root.val + left + right;
        max = Math.max(temp, max);
        //带着最大的情况返回到父节点
        return root.val + Math.max(left, right);
    }
}
// @lc code=end
