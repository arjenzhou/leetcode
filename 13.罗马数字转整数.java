import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int res = 0;
        while(str.length() > 0) {
            int num = 0;
            if(str.length() >= 2) {
                String temp = str.substring(0, 2);
                num = map.get(temp) == null ? 0 : map.get(temp);
            }
            if(num != 0) {
                str = str.substring(2);
            } else {
                num = map.get(str.substring(0, 1));
                str = str.substring(1);
            }
            res += num;
        }
        return res;
    }
}
// @lc code=end

