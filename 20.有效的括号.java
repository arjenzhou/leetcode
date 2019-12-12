/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()) {
            char character = s.charAt(index);
            index ++;
            if(character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char ch = stack.pop();
                if(character == ')' && ch == '(') {
                    continue;
                } else if (character == ']' && ch == '[') {
                    continue;
                } else if (character == '}' && ch == '{') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

