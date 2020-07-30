/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 * 
 * 深度优先搜索
 * 从陆地-->水域  ||  从陆地-->边界  周长加一
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1){
                    return dfs(grid, row, column);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int column){
        //边界
        if(!(row>=0 && row<grid.length  && column>=0 && column<grid[0].length)){
            return 1;
        }

        //水域
        if(grid[row][column] == 0){
            return 1;
        }

        //遍历过
        if(grid[row][column] == 2){
            return 0;
        }

        //没有遍历过
        grid[row][column] = 2;
        return  dfs(grid, row+1, column) + 
                dfs(grid, row-1, column) + 
                dfs(grid, row, column+1) + 
                dfs(grid, row, column-1);
    }
}
// @lc code=end

