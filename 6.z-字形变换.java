/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        char[] arr = s.toCharArray();
        int length = arr.length;
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        boolean isPositive = true;
        int lineNo = 0;
        int curIndex = 0;
        //若处理单行的情况，需要添加判断逻辑，所以上面直接将单行返回。
        while (curIndex < length) {
            sbs[lineNo].append(arr[curIndex++]);
            if (isPositive) {
                lineNo++;
            } else {
                lineNo--;
            }
            if (lineNo == numRows - 1 || lineNo == 0) {
                isPositive = !isPositive;
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }
        return res.toString();
    }
}
// @lc code=end
