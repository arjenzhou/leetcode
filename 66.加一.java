/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1] ++;
        for(int i = digits.length - 1; i >= 0; i --){
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }
        if(carry == 1) {
            int [] res = new int[digits.length + 1];
            res[0] = 1;
            for(int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}
// @lc code=end

