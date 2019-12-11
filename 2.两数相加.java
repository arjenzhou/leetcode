/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            int t = l1.val + l2.val + carry;
            int cur = t % 10;
            carry = t / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int t = l1.val + carry;
            int cur = t % 10;
            carry = t / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int t = l2.val + carry;
            int cur = t % 10;
            carry = t / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 == null){
            if(carry != 0)
                head.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
// @lc code=end

