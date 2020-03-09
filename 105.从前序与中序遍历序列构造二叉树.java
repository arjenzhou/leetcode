import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    TreeNode help(int [] preorder, int [] inorder, int pl, int pr, int il, int ir){
        if(pl == pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int index = 0;
        for(int i = il; i < ir; i ++) {
            if(preorder[pl] == inorder[i]) {
                index = i;
                break;
            }
        }
        int llen = index - il;
        root.left = help(preorder, inorder, pl + 1, pl + llen + 1, il, index);
        root.right = help(preorder, inorder, pl +  llen + 1, pr, index + 1, ir);
        return root;
    }
}
// @lc code=end

