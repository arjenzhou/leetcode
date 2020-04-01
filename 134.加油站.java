/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int total = 0;
        int cur = 0;
        int start = 0;

        //总油量大于0

        //当前油量小于0时，说明起点不行，尝试下一个起点
        //尝试下一个作为起点的原因是：该点之前都可以到达。
        //且该点一定是油量最高的点，否则之前就会停止（只有该点之前的剩余油量为负才能出现这种情况）。
        for(int i = 0; i < length; i ++) {
            total += (gas[i] - cost[i]);
            cur += (gas[i] - cost[i]);

            if(cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? start : - 1;
    }
}
// @lc code=end

