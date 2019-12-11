/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) 
            return s.isEmpty();
        //当前字符是否匹配
        boolean first_match = (!s.isEmpty() &&
        (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*') {
            //s[0] != p[0] 时，p 去掉 .*
            //当前字符匹配，继续判断 s 的下一个是否匹配。 如： s:aaa p:a*
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            //若不是 *， 则正常处理
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
// @lc code=end

