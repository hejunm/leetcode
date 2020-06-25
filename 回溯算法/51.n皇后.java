/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * 
 * 选择：
 * 指定行，将Q放到第几列
 * 
 * 约束：
 * row， column，两个斜线 只有一个Q
 * 
 * hill:  捺 \, 在同一斜线上的row-column相等。
 * row 取值范围：[0, n-1], column取值范围：[0, n-1]
 * row-column取值范围：[-(n-1), n-1], 将负数映射为正数同一加n得：[1, 2*n-1]
 *
 * dales: 撇 /, 在同一斜线上的row+col相等。 
 * row 取值范围：[0, n-1], column取值范围：[0, n-1]
 * row+column取值范围：[0, 2*(n-1)]
 * 存在的值：[0, 2*(n-1)]
*/
class Solution {
    int n;          //n皇后
    int queens[];   //每一行 Q放在了那一列
    int columns[];  //对应列是否放置Q
    int hills[];    // "hill" diagonals  \ hills[row - col + n]
    int dales[];    // "dale" diagonals  / dale[row+col]
    List<List<String>> output = new ArrayList();    //返回值

    private void init(int n){
        this.n = n;
        queens = new int[n];
        columns = new int[n];
        hills = new int[2*n];
        dales = new int[2*n];
    }

    private void placeQueen(int row, int column){
        queens[row] = column;
        columns[column] = 1;
        hills[row - column + n] = 1;
        dales[row + column] = 1;
    }

    private void removeQueen(int row, int column){
        queens[row] = 0;
        columns[column] = 0;
        hills[row - column + n] = 0;
        dales[row + column] = 0;
    }

    private boolean canPlaceQueen(int row, int column){
        int result = columns[column] + hills[row - column + n] + dales[row + column];
        return result==0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
          int col = queens[i];
          StringBuilder sb = new StringBuilder();
          for(int j = 0; j < col; ++j) sb.append(".");
          sb.append("Q");
          for(int j = 0; j < n - col - 1; ++j) sb.append(".");
          solution.add(sb.toString());
        }
        output.add(solution);
      }

    private void backtrack(int row){
        for (int column = 0; column < this.n; column++) {
            if(canPlaceQueen(row, column)){
                placeQueen(row, column);
                if(row == this.n-1){ //会后一行
                    addSolution();
                }else{
                    backtrack(row+1);
                }
                removeQueen(row, column);
            }
        }
    } 

    public List<List<String>> solveNQueens(int n) {
        init(n);
        backtrack(0);
        return this.output;
    }
}
// @lc code=end

