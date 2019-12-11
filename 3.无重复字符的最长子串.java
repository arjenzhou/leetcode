import java.util.Arrays;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char [] characters = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max, length, left, right;
        max = length = left = right = 0;
        while(right < characters.length){
            if(set.contains(characters[right])){
                set.remove(characters[left ++]);
            }else{
                set.add(characters[right ++]);
            }
            max = Math.max(right - left, max);
        }
        return max;

        // char [] characters = s.toCharArray();
        // int [] arr = new int[26];
        // int max, length, left, right;
        // max = length = left = right = 0;
        // Arrays.fill(arr, -1);
        // while(right < characters.length){
        //     int originIndex = arr[characters[right] - 'a'];
        //     if(originIndex != -1){
        //         //之前存在过，窗口为从原地址+1到此index
        //         left = originIndex + 1;
        //     }else{
        //         //之前未存在，继续扩大窗口
        //     }
        //     arr[characters[right] - 'a'] = right; 
        //     length = right - left + 1;
        //     max = max > length ? max : length;
        //     right ++;
        // }
        // return max;
    }
}
// @lc code=end

