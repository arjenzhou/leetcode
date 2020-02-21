import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        /**
         * G(0) = [0]
         * 
         * G'(1) = [0 ]
         * R'(1) = [1 ]
         * G(1) = [0, 1] = G(0) U [for each reserve number in G(0) + 1]
         * 
         * G'(2) = [0 0, 0 1] = G(1)
         * R'(2) = [1 1, 1 0]
         * G(2) = [00, 01, 11, 10] = G(1) U [for each reserve number in G(1) + 10]
         * 
         * G'(3) = [0 00, 0 01, 0 11, 0 10]
         * R'(3) = [1 10, 1 11, 1 01, 1 00]
         * G(3) = [000, 001, 011, 010, 110, 111, 101, 100]
         */
        List<Integer> res = new ArrayList<>();
        res.add(0);

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            //左移补0
            head <<= 1;
        }
        return res;
    }
}
// @lc code=end

