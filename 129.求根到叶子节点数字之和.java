/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    int help(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        } else {
            int temp = cur * 10 + root.val;
            if (root.left == null && root.right == null) {
                return temp;
            } else {
                return help(root.left, temp) + help(root.right, temp);
            }
        }
    }
}
// @lc code=end
