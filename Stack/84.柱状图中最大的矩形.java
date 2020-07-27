import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] new_heights = new int[heights.length+2]; //添加哨兵
        for (int i = 0; i < heights.length; i++) {
            new_heights[i+1] = heights[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < new_heights.length; i++) {
            while(!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]){
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

