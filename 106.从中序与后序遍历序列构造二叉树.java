/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    TreeNode help(int [] inorder, int [] postorder, int il, int ir, int pl, int pr) {
        if(pl > pr || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pr]);
        int index = il;
        for(int i = il; i <= ir; i ++) {
            if(inorder[i] == postorder[pr]) {
                index = i;
                break;
            }
        }    
        int rlen = ir - index;
        root.left = help(inorder, postorder, il, index - 1, pl, pr - rlen - 1);
        root.right = help(inorder, postorder, index + 1, ir, pr - rlen, pr - 1);
        return root;
    }
}
// @lc code=end

