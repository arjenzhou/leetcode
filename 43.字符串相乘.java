/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")|| num2.equals("0")){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        //每一位与另一数相乘
        for(int i = num1.length() - 1; i >= 0; i -- ) {
            StringBuilder tempRes = new StringBuilder();
            int carry = 0;
            for(int j = num2.length() - 1; j >= 0; j -- ) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                carry = temp / 10;
                temp %= 10;
                tempRes.append(temp);
            }
            if(carry != 0) {
                tempRes.append(carry);
            }
            tempRes = tempRes.reverse();

            int m = num1.length() - 1 - i;
            while(m > 0) {
                tempRes.append(0);
                m --;
            }
            //结果与暂时乘积相加
            int index1 = tempRes.length() - 1;
            int index2 = res.length() - 1;
            StringBuilder sb = new StringBuilder();
            carry = 0;
            while(index1 >= 0 && index2 >= 0){
                int temp = (tempRes.charAt(index1) - '0') + (res.charAt(index2) - '0') + carry;
                carry = temp / 10;
                temp %= 10;
                sb.append(temp);
                index1 --;
                index2 --;
            }
            while(index1 >= 0) {
                int temp = (tempRes.charAt(index1) - '0') + carry;
                carry = temp / 10;
                temp %= 10;
                sb.append(temp);
                index1 --;
            }
            while(index2 >= 0) {
                int temp = (res.charAt(index2) - '0') + carry;
                carry = temp / 10;
                temp %= 10;
                sb.append(temp);
                index2 --;
            }
            
            if(carry != 0) {
                sb.append(carry);
            }
            res = sb.reverse();
        }
        return res.toString();
    }
}
// @lc code=end

