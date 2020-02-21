/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root ==null) {
            return list;
        }
        help(root, list);
        return list;
    }

    public void help(TreeNode root, List<Integer> list) {
        if(root.left != null) {
            help(root.left, list);
        }
        list.add(root.val);
        if(root.right != null) {
            help(root.right, list);
        }
    }
}

// public class Solution {
//     public List < Integer > inorderTraversal(TreeNode root) {
//         List < Integer > res = new ArrayList < > ();
//         Stack < TreeNode > stack = new Stack < > ();
//         TreeNode curr = root;
//         while (curr != null || !stack.isEmpty()) {
//             while (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
//             curr = stack.pop();
//             res.add(curr.val);
//             curr = curr.right;
//         }
//         return res;
//     }
// }
// @lc code=end

