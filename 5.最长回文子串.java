/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char [] arr = s.toCharArray();
        int length = arr.length;
        if(s.length() <= 0) {
            return "";
        }
        int max = 0;
        String res = new String();

        for(int i = 0; i < length; i ++) {
            int l = i;
            int r = length - 1 - i;
            int tl = Math.min(l, r);
            int temp;

            //以 s[i] 为中轴，向两边扩展
            for(int j = 0; j <= tl; j ++){
                if(arr[i - j] != arr[i + j]) {
                    break;
                }
                //更新最大值和字符串
                if(max <= (temp = 2 * j + 1)) {
                    max = temp;
                    res = new String(arr, i - j, max);
                }
            }
            //以 s[i], s[i + 1] 为轴，向两边扩展
            for(int j = 0; j <= tl && (i + 1 + j) < length; j ++) {
                if(arr[i - j] != arr[i + 1 + j]) {
                    break;
                }
                if(max < (temp = 2 * (j + 1))) {
                    max = temp;
                    res = new String(arr, i - j, max);
                }
            }

        }
        return res;
    }
}
// @lc code=end

