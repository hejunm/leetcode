/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * dp[row][column]: 到达 [row, column]的最小路径和
 * 状态转移方程： dp[row][column] = min(dp[row-1][column], dp[row][column-1]) + grid[row][column]
 * 初始条件：
 *  dp[0][column] = dp[0][column-1] + grid[0][column];
 *  dp[row][0] = dp[row-1][0] + grid[row][0];
 * 返回值：dp[row-1][column-1]
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        //初始条件
        dp[0][0] = grid[0][0];
        for (int column = 1; column < columns; column++) {
            dp[0][column] = dp[0][column-1] + grid[0][column];
        }
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row-1][0] + grid[row][0];
        }

        //状态转移方程
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                dp[row][column] = Math.min(dp[row-1][column], dp[row][column-1]) + grid[row][column];
            }
        }
        return dp[rows-1][columns-1];
    }
}
// @lc code=end

