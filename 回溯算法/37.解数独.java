/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 题解： https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode/
 */
// @lc code=start

/**
n = boxSize = 3;
N = boxSize*boxSize = 9;


1， 如何快速的判断 一个数 在 行 列 宫内是否出现？
    创建 每行 列 宫 字符集合；
    优化为 --> 使用数组存储 row[r][num] 1:有值，0：无值;其中num=[0, N]；时间复杂度1 

2， 需要回溯的方格
    board[row][colume] = '.'

3， 条件选择 1-9 
    填充一个数 需要满足的条件：行，列， 3*3宫 1-9的数字只出现一次
    行 列 宫 字符集合 添加选中的条件；
    递归下个空格
    回溯 从 行 列 宫 字符集合 中撤销之前选择的
*/
class Solution {
    int n = 3;      //box size
    int N = n*n;    //row size
    int rows[][] = new int[N][N+1];
    int columes[][] = new int[N][N+1];
    int boxs[][] = new int[N][N+1];
    char[][] board;
    boolean sudokuSolved = false;

    private int getBoxIndex(int row, int colume){
        return (row/3)*3 + colume/3;
    }

    private void placeNumber(int row, int colume, int num){
        int boxIndex = getBoxIndex(row, colume);
        rows[row][num]++;
        columes[colume][num]++;
        boxs[boxIndex][num]++;
        board[row][colume] = (char)('0'+num);
    }

    private boolean canPlaceNumber(int row, int colume, int num){
        int boxIndex = getBoxIndex(row, colume);
        return rows[row][num] + columes[colume][num] + boxs[boxIndex][num] == 0;
    } 

    private void removePlacedNumber(int row, int colume, int num){
        int boxIndex = getBoxIndex(row, colume);
        rows[row][num]--;
        columes[colume][num]--;
        boxs[boxIndex][num]--;
        board[row][colume] = '.';
    }

    private void placeNextNumber(int row, int colume){
        if(row==N-1 && colume==N-1){
            sudokuSolved = true;
            return;
        }
        if(colume==N-1){ //换行
            backtrack(row+1, 0);
        }else{
            backtrack(row, colume+1);
        }
    }

    private void init(char[][] board){
        this.board = board;
        for(int row=0; row < N; row++){
            for (int colume = 0; colume < N; colume++) {
                char c = board[row][colume];
                if(c != '.'){
                    placeNumber(row, colume, c-'0');
                }
            }
        }
    }

    private void backtrack(int row, int colume){
        if(this.board[row][colume] == '.'){
            for(int i=1; i<=9; i++){
                if(canPlaceNumber(row,colume,i)){
                    placeNumber(row, colume, i);
                    placeNextNumber(row, colume);
                    if(sudokuSolved == true){ //得到结果
                        return;
                    }
                    removePlacedNumber(row, colume, i);
                }
            }
        }else{
            placeNextNumber(row, colume);
        }
    }

    public void solveSudoku(char[][] board) {
        init(board);
        backtrack(0,0);
    }
}
// @lc code=end

