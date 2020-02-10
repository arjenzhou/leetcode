/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), slow = dummy, fast = head;
        dummy.next = head;
        while(fast.next != null) {
            if(slow.next.val == fast.next.val) {
                fast = fast.next;
                if(fast.next == null && slow.next != fast) {
                    slow.next = null;
                }
            } else {
                if(slow.next != fast) {
                    slow.next = fast.next;
                    fast = slow;
                } else {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return dummy.next;
    }
}
// @lc code=end

