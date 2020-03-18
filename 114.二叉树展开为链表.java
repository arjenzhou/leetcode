/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
/**
 * 
    将左子树插入到右子树的地方
    将原来的右子树接到左子树的最右边节点
    考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
 */
class Solution {
    public void flatten(TreeNode root) {
        while(root != null) {
            if(root.left == null) {
                root = root.right;
            } else {
                TreeNode temp = root.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
// @lc code=end
