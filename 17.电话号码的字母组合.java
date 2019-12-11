import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    char [][] arr = {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0) {
            return list;
        }
        //将char处理成int
        char [] t = digits.toCharArray();
        int [] digit = new int[t.length];
        for(int i = 0; i < t.length; i ++) {
            digit[i] = t[i] - '0';
        }
        //处理第一个数，递归调用
        for(int i = 0; i < arr[digit[0]].length; i ++) {
            letterCombinations(arr[digit[0]][i], 0, digit, "");
        }
        return list;
    }
    //递归方法，当到达结尾时将其添加进list
    private void letterCombinations(char character, int index, int [] digit, String str){
        str += character;
        if(index == digit.length - 1) {
            list.add(str);
            return;
        }
        for(int i = 0; i < arr[digit[index + 1]].length; i ++) {
            letterCombinations(arr[digit[index + 1]][i], index + 1, digit, str);
        }
    }
}
// @lc code=end

