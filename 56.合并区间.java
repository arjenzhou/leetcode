import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        //根据每个数组的第一个数排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        //借助 LinkedList 的 getLast() 方法
        LinkedList<int[]> res = new LinkedList<>();
        for(int i = 0; i < intervals.length; i ++) {
            //初始化，或加入一个新段（结果集中右小于输入数组中左）
            if(res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            //更新结果集最后数的右段
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        //int[0][0] 会自动扩容
        return res.toArray(new int[0][0]);
    }
}
// @lc code=end

