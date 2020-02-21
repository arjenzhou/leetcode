/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = n - 1;
        int cur = nums1.length - 1;
        while(cur >= 0 && cur1 >= 0 && cur2 >= 0) {
            if(nums1[cur1] > nums2[cur2]) {
                nums1[cur] = nums1[cur1];
                cur1 --;
            } else {
                nums1[cur] = nums2[cur2];
                cur2 --;
            }
            cur --;
        }
        
        if(cur2 >= 0) {
            for(int i = cur; i >= 0; i --, cur2 --) {
                nums1[i] = nums2[cur2];
            }
        }
        // System.arraycopy(nums2, 0, nums1, 0, cur2 + 1);
    }
}
// @lc code=end

