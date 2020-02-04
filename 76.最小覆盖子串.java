/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, 0); //初始化s的字符，全部为key-0
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); //t中出现的字符数 key-int
            } else {
                return "";
            }
        }
        String result = "";
        //记录需要被匹配的次数
        int count = t.length();
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //将字符进行匹配
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            right++;
            while (count == 0) {
                //替换最小结果
                if(result.length() == 0){
                    result = s.substring(left, right);
                }else if (result.length() > (right - left)) {
                    result = s.substring(left, right);
                }
                //移动左指针
                char c1 = s.charAt(left);
                if (map.get(c1) == 0) {
                    count++;
                }
                map.put(c1, map.get(c1) + 1);
                left++;
            }
        }
        return result;
    }
}
// @lc code=end
