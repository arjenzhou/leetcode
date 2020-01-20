/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        boolean [] isVisited = new boolean[n];
        return help(n, k, step(n - 1), isVisited);
    }

    /**
     * @param n 
     * @param k 该组的第k个
     * @param m 每组m个数
     * @param isVisited 使用过的数
     */
    String help(int n, int k, int m, boolean[] isVisited) {
        //第group组
        int group = (k - 1) / m;
        //找未用过的第group个数
        int i = 0;
        int count = 0;
        while(i < isVisited.length) {
            if(!isVisited[i]) {
                if(count == group) {
                    break;
                } else {
                    count ++;
                }
            }
            i ++;
        }
        isVisited[i] = true;
        
        if(n - 1 > 0) {
            return String.valueOf(i + 1) + help(n - 1, k - group * m, m / (n - 1), isVisited);
        } else {
            return i + 1 + "";
        }
    }
    //阶乘
    int step(int n) {
        int res = 1;
        for(int i = 2; i <= n; i ++) {
            res *= i;
        }
        return res;
    }
}
// @lc code=end

