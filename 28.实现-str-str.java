/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(needle.length() > haystack.length()) {
            return -1;
        }
        int index1 = 0, index2 = 0;
        while(index1 < haystack.length() && index2 < needle.length()) {
            if(haystack.charAt(index1) == needle.charAt(index2)) {
                if(index2 == needle.length() - 1) {
                    return index1 - index2;
                }
                index2 ++;
            } else {
                index1 = index1 - index2;
                index2 = 0;
            }
            index1 ++;
        }
        return -1;
    }
}
// @lc code=end

