/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        //去掉开头的空格
        str = str.trim();
        int mark = 1;
        int res = 0;
        int index = 0;
        if(str.length() <= 0) {
            return 0;
        }
        //去掉开头的正负号
        char m = str.charAt(0);
        if(m == '-' || m =='+') {
            mark = m == '-' ? -1 : 1;
            str = str.substring(1);
        }
        if(str.length() <= 0) {
            return 0;
        }
        //去开头的0
        int start = 0;
        while(start < str.length()){
            if(str.charAt(start) - '0' == 0) {
                str = str.substring(1);
            } else {
                break;
            }
        }
        
        while(index < str.length()) {
            int t = str.charAt(index) - '0';
            //不合规直接截断
            if(!isLegalNumber(t)){
                break;
            }
            if(index == 9 && str.length() == 10) {
                //比 MAX 大或者比 MIN 小必定溢出
                if(res > Integer.MAX_VALUE / 10) {
                    return mark == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                if(res == Integer.MAX_VALUE / 10){
                    if(mark == 1 && t > Integer.MAX_VALUE % 10) {
                        return Integer.MAX_VALUE;
                    } else if(t > Integer.MIN_VALUE % 10 * -1){
                        return Integer.MIN_VALUE;
                    }
                }
            }
            if(index == 10) {
                return mark == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res *= 10;
            res += t;
            index ++;
        }
        return mark * res;
    }

    private boolean isLegalNumber(int num){
        if(num >= 0 && num <= 9) {
            return true;
        }
        return false;
    }
}
// @lc code=end

