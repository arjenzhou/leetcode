/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length ++;
        }
        k %= length;
        if(k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        temp = dummy;
        while(k > 0) {
            temp = temp.next;
            k --;
        }
        while(temp.next != null) {
            temp = temp.next;
            dummy = dummy.next;
        }
        //dummy 和 dummy.next 分开
        head = dummy.next;
        dummy.next = null;
        temp.next = pre;
        return head;

    }
}
// @lc code=end

