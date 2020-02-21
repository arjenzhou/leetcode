/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        n -= m;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null, next = null, pp = null, ppn = null;

        while (head != null && m > 0) {
            if (m == 2) {
                pp = head;
            }
            if (m == 1) {
                ppn = head;
                pre = head;
            }
            head = head.next;
            m--;
        }
        if (pp == null) {
            pp = dummy;
        }
        while (head != null && n > 0) {
            n--;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        //initial pre's pre
        pp.next = pre;
        //pp's next
        ppn.next = head;
        return dummy.next;
    }
}
// @lc code=end
