/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        // s[f] 之前子串最少需要分割的次数
        int[] f = new int[n + 1];
        f[0] = -1;

        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                // 如果 j 之后半部分子串是回文串
                if (isPal(s.substring(j, i))) {
                    // 那么整个字符串就是j前面的次数+1(因为后面是回文，只需要在j分一次)
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n];
    }

    boolean isPal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
