/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true;
        } else if(r1 == null || r2 == null) {
            return false;
        } 
        if(r1.val == r2.val) {
           return  isMirror(r1.left, r2.right) 
            && isMirror(r1.right, r2.left);
        }
        return false;
    }
}
// @lc code=end

