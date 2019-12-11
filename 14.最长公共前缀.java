/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0) {
            return "";
        }
        char alphbet;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i ++) {
            max = max < strs[i].length() ? max : strs[i].length();
        }
        int length = 0;
        for(length = 0; length < max; length ++) {
            if(strs[0].length() > 0) {
                alphbet = strs[0].charAt(length);
            } else {
                return strs[0].substring(0, length);
            }
            for(int index = 0; index < strs.length; index ++) {
                if(alphbet != strs[index].charAt(length)) {
                    return strs[0].substring(0, length);
                }
            }
        }
        return strs[0].substring(0, length);
    }
}
// @lc code=end

