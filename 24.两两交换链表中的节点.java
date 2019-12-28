/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        dummy.next = head;
        while(head != null && head.next != null) {
            dummy.next = head.next;
            head.next = dummy.next.next;
            dummy.next.next = head;
            dummy = head;
            head = dummy.next;
        }
        return res.next;
    }
}
// @lc code=end

