/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount = obstacleGrid.length;
        int columnCount = obstacleGrid[0].length;
        int dp[][] = new int[rowCount][columnCount];

        //第一行
        boolean firstRowObstacle = false;
        for (int columu = 0; columu < columnCount; columu++) {
            firstRowObstacle = firstRowObstacle || obstacleGrid[0][columu]==1;
            dp[0][columu] = firstRowObstacle? 0 : 1;
        }

        //第一列
        boolean firstColumnObstacle = false;
        for (int row = 0; row < rowCount; row++) { //第一列
            firstColumnObstacle = firstColumnObstacle || obstacleGrid[row][0]==1;
            dp[row][0] = firstColumnObstacle? 0 : 1;
        }

        for (int row = 1; row < rowCount; row++) {
            for (int column = 1; column < columnCount; column++) {
                if(obstacleGrid[row][column] == 1){
                    dp[row][column] = 0;
                }else{
                    dp[row][column] = dp[row-1][column] + dp[row][column-1];
                }
            }
        }
        return dp[rowCount-1][columnCount-1];
    }
}
// @lc code=end

