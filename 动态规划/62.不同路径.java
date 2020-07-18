/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 * 动态规划：
 * dp[i][j]： 到达坐标 i,j 路径数；
 * 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1];
 * 初始条件：dp[0][j] = 1; dp[i][0] = 1;  第一行 第一列路径都是1
 * 
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int rowCount = n;
        int columnCount = m;
        int dp[][] = new int[rowCount][columnCount];
        for (int columu = 0; columu < columnCount; columu++) { //第一行
            dp[0][columu] = 1;
        }
        for (int row = 0; row < rowCount; row++) { //第一列
            dp[row][0] = 1;
        }

        for (int row = 1; row < rowCount; row++) {
            for (int column = 1; column < columnCount; column++) {
                dp[row][column] = dp[row-1][column] + dp[row][column-1];
            }
        }
        return dp[rowCount-1][columnCount-1];
    }
}
// @lc code=end

