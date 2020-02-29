/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if(root ==null){
            return;
        }
        inOrder(root.left);
        // 4, 2, 3, 1
        // ^        
        if(first == null && root.val < pre.val) {
            first = pre;
        }
        // 4, 2, 3, 1
        // ^        ^
        if(first != null && root.val < pre.val) {
            second = root;
        }
        pre = root;
        inOrder(root.right);
    }
}
// @lc code=end

