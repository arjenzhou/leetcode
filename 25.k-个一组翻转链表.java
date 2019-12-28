/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int count = k;
        ListNode cur = head;
        ListNode prev = null, next = null, t = head, dummy = null;
        ListNode tail = head;
        boolean b = true;
        int length = 0;
        while(head != null) {
            head = head.next;
            length ++;
        }
        if(k > length) {
            return cur;
        }
        int time = length / k;
        while(time -- > 0){
            while(cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                if(-- count == 0) {
                    if(!b) {
                        tail.next = prev;
                        tail = t;
                    }
                    if(time == length / k - 1) {
                        dummy = prev;
                    }
                    t = next;
                    break;
                }
            }
            b = false;
            prev = next = null;
            count = k;
        }
        tail.next = cur;
        return dummy;
    }
}
// @lc code=end

