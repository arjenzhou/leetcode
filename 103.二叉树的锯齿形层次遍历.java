/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean left = true;
        List<List<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur;
                if(left) {
                    cur = queue.pollLast();
                    if(cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                    if(cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                } else {
                    cur = queue.poll();
                    if(cur.right != null) {
                        queue.add(cur.right);
                    }
                    if(cur.left != null) {
                        queue.add(cur.left);
                    }
                }
                list.add(cur.val);
            }
            ret.add(list);
            left = !left;
        }
        return ret;
    }
}
// @lc code=end

