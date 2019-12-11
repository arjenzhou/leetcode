/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        
        int k1 = (length + 1) / 2;
        int k2 = (length + 2) / 2;
        //无论是奇数的情况还是偶数的情况，都能够获得中位数。
        return (getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, k1) 
        + getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, k2)) / 2;
    }

    private double getKth(int [] arr1, int l1, int r1, int [] arr2, int l2, int r2, int k){
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        //后面的代码假设第一个数组长度短，出现第一个数组长时将其调换
        if(len1 > len2){
            return getKth(arr2, l2, r2, arr1, l1, r1, k);
        }
        //若其中一个数组（这里是第一个）长度为0时，直接到第二个数组中取第 k 个数，这是递归的两个结束条件之一。
        if(len1 == 0){
            return arr2[l2 + k - 1];
        }
        //若 k = 1，即取第一个数时，比较两个数组的第一个数即可，这是递归的两个结束条件之一。
        if(k == 1){
            return Math.min(arr1[l1], arr2[l2]);
        }
        //若 k / 2 超过了数组的长度，那么直接定位到最后一位
        int i = l1 - 1 + Math.min(k / 2, len1);
        int j = l2 - 1 + Math.min(k / 2, len2);
        //抛弃较小的一部分，k 也需要抛弃相应的长度（需要通过 i/j 重新计算长度，因为存在两种可能性）
        if(arr1[i] > arr2[j]){
            return getKth(arr1, l1, r1, arr2, j + 1, r2, k - (j + 1 - l2));
        }
        else{
            return getKth(arr1, i + 1, r1, arr2, l2, r2, k - (i + 1 - l1));
        }
    }
}
// @lc code=end
// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
// 解法三