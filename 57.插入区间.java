import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int [][] arr = Arrays.copyOf(intervals, intervals.length + 1);
         arr[arr.length - 1] = newInterval;
         Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
         //借助 LinkedList 的 getLast() 方法
         LinkedList<int[]> res = new LinkedList<>();
         for(int i = 0; i < arr.length; i ++) {
             //初始化，或加入一个新段（结果集中右小于输入数组中左）
             if(res.isEmpty() || res.getLast()[1] < arr[i][0]) {
                 res.add(arr[i]);
             //更新结果集最后数的右段
             } else {
                 res.getLast()[1] = Math.max(res.getLast()[1], arr[i][1]);
             }
         }
         //int[0][0] 会自动扩容
         return res.toArray(new int[0][0]);
    }
}
// @lc code=end

