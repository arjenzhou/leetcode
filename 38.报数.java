/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        return help("1", n - 1);
    }

    private String help(String n, int m) {
        int index = 0;
        int count = 0;
        String str = n + "";
        String res = "";
        char last = str.charAt(0);
        while(index < str.length()) {
            char cur = str.charAt(index);
            if(cur == last) {
                count ++;
            } else {
                res += count;
                res += last;
                count = 1;
            }
            last = cur;
            index ++;
        }
        res += count;
        res += last;
        if(m == 1) {
            return res;
        } else {
            return help(res, m - 1);
        }
    }
}
// @lc code=end

