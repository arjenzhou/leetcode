/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        for(int i = 0; i < lists.length - 1; i ++) {
            ListNode dummy = new ListNode(0);
            ListNode t = dummy;
            while(lists[i] != null && lists[i + 1] != null) {
                if(lists[i].val < lists[i + 1].val) {
                    t.next = lists[i];
                    lists[i] = lists[i].next;
                } else {
                    t.next = lists[i + 1];
                    lists[i + 1] = lists[i + 1].next;
                }
                t = t.next;
            }
            if(lists[i] != null) {
                t.next = lists[i];
            }
            if(lists[i + 1] != null) {
                t.next = lists[i + 1];
            }
            lists[i + 1] = dummy.next;
        }
        if(lists.length == 0) {
            return null;
        }
        return lists[lists.length - 1];
    }
}
// @lc code=end

