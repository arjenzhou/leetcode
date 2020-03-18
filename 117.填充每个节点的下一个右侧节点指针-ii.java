/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    Node connect(Node root) {
        if (root == null)
            return root;
        Node pre = root;
        Node cur = null;
        while (true) {
            cur = pre;
            while (cur != null) {
                // 找到至少有一个孩子的节点
                if (cur.left == null && cur.right == null) {
                    cur = cur.next;
                    continue;
                }
                // 找到当前节点的下一个至少有一个孩子的节点
                Node next = cur.next;
                while (next != null && next.left == null && next.right == null) {
                    next = next.next;
                    if (next == null) {
                        break;
                    }
                }
                // 当前节点的左右孩子都不为空，就将 left.next 指向 right
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                // 要接上 next 的节点的孩子，所以用 temp 处理当前节点 right 为 null 的情况
                Node temp = cur.right == null ? cur.left : cur.right;

                if (next != null) {
                    // next 左孩子不为 null，就接上左孩子。
                    if (next.left != null) {
                        temp.next = next.left;
                        // next 左孩子为 null，就接上右孩子。
                    } else {
                        temp.next = next.right;
                    }
                }

                cur = cur.next;
            }
            // 找到拥有孩子的节点
            while (pre.left == null && pre.right == null) {
                pre = pre.next;
                // 都没有孩子说明已经是最后一层了
                if (pre == null) {
                    return root;
                }
            }
            // 进入下一层
            pre = pre.left != null ? pre.left : pre.right;
        }
    }
}
// @lc code=end
