import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");
        String str = num + "";
        while (!str.equals("")) {
            int digit = str.length();
            int first = str.charAt(0) - '0';
            if (digit == 1) {
                if (first == 1) {
                    sb.append("I");
                } else if (first >= 2 && first <= 3) {
                    for (int i = 0; i < first; i++) {
                        sb.append("I");
                    }
                } else if (first == 4) {
                    sb.append("IV");
                } else if (first == 5) {
                    sb.append("V");
                } else if (first >= 6 && first <= 8) {
                    sb.append("V");
                    for (int i = 0; i < first - 5; i++) {
                        sb.append("I");
                    }
                } else if (first == 9) {
                    sb.append("IX");
                }
            } else if (digit == 2) {
                if (first == 1) {
                    sb.append("X");
                } else if (first >= 2 && first <= 3) {
                    for (int i = 0; i < first; i++) {
                        sb.append("X");
                    }
                } else if (first == 4) {
                    sb.append("XL");
                } else if (first == 5) {
                    sb.append("L");
                } else if (first >= 6 && first <= 8) {
                    sb.append("L");
                    for (int i = 0; i < first - 5; i++) {
                        sb.append("X");
                    }
                } else if (first == 9) {
                    sb.append("XC");
                }
            } else if (digit == 3) {
                if (first == 1) {
                    sb.append("C");
                } else if (first >= 2 && first <= 3) {
                    for (int i = 0; i < first; i++) {
                        sb.append("C");
                    }
                } else if (first == 4) {
                    sb.append("CD");
                } else if (first == 5) {
                    sb.append("D");
                } else if (first >= 6 && first <= 8) {
                    sb.append("D");
                    for (int i = 0; i < first - 5; i++) {
                        sb.append("C");
                    }
                } else if (first == 9) {
                    sb.append("CM");
                }
            } else if (digit == 4) {
                if (first == 1) {
                    sb.append("M");
                } else if (first >= 2 && first <= 3) {
                    for (int i = 0; i < first; i++) {
                        sb.append("M");
                    }
                }
            }
            str = str.substring(1);
        }
        return sb.toString();
    }
}
// @lc code=end

//逐步向下减
// class Solution {
//     public String intToRoman(int num) {
//         StringBuilder ans = new StringBuilder();
//         String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
//         int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
//         int index = 0;
//         while (num > 0) {
//             int count = num / arab[index];
//             while (count-- > 0) {
//                 ans.append(roman[index]);
//             }
//             num %= arab[index];
//             index++;
//         }
//         return ans.toString();
//     }
// }