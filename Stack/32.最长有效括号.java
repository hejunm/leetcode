import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 * 使用栈
 * 
 * 两种case需要入栈：
 * 匹配到（ ;
 * 一、入栈条件为1.栈为空 2.当前字符是'(' 3.栈顶符号位')'，因为三种条件都没办法消去成对的括号。
 * 二、计算结果：符合消去成对括号时，拿当前下标减去栈顶下标即可
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(stack.isEmpty() || stack.peek() == ')' || c=='('){
                stack.push(i);
            }else{
                stack.pop();
                result = Math.max(result, i - stack.peek());
            }
        }
        return result;
    }
}
// @lc code=end

