import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 * 单调栈
 * 移除k位，使得剩下的数字最小。左边的数取最小。
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        char[] numChars = num.toCharArray();
        Deque<Integer>stack = new LinkedList<>();

        for (char c : numChars) {
            int n = c - '0';
            while((k > 0) && !stack.isEmpty() && stack.peek() > n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;

        while(!stack.isEmpty()) {
            int digit = stack.pollLast();
            if(leadingZero && digit == 0){
                continue;
            } else{
                leadingZero = false;
                ret.append(digit);
            }
        }
        if(ret.length() == 0){
            return "0";
        }else{
            return ret.toString();
        }
    }
}
// @lc code=end

