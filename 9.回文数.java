/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int res = 0;
        int t = x;
        while(t != 0){
            res *= 10;
            res += t % 10;
            t /= 10;
        }
        return res == x;
    }
}
// @lc code=end

