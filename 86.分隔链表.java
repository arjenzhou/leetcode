/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode secondHead = new ListNode(0), dummy = new ListNode(0), secondDummy = secondHead;
        dummy.next = head;
        head = dummy;

        while(head.next != null) {
            if(head.next.val >= x) {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
                secondHead.next = temp;
                secondHead = secondHead.next;
            } else {
                head = head.next;
            }
        }
        head.next = secondDummy.next;
        return dummy.next;
    }
}
// @lc code=end

