import java.util.HashSet;
import java.util.Set;

import com.sun.tools.javac.api.JavacTaskPool.Worker;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
/**
 * 回溯法：
 * 选择项： 上下左右
 * 
 * 需记录遍历过的位置，以满足 同一个单元格内的字母不允许被重复使用。
 * 使用set记录，row*200 + column
 * 
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if(backtrack(board, word, 0, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int charIndex, int row, int column){
        if(board[row][column] != word.charAt(charIndex)){ //当前字母不相等 没有匹配成功（包含了 ‘*’） 
            return false;
        }

        if(charIndex == word.length() -1){
            return true;
        }

        char temp = board[row][column];
        board[row][column] = '*';
        if(
            (row > 0 &&                         backtrack(board, word, charIndex+1, row-1, column)) ||
            (row < board.length-1 &&            backtrack(board, word, charIndex+1, row+1, column)) ||
            (column > 0 &&                      backtrack(board, word, charIndex+1, row, column-1)) ||
            (column < board[0].length-1 &&      backtrack(board, word, charIndex+1, row, column+1))
        ){
            return true;
        }
        board[row][column] = temp; //回溯
        return false;
    }
}
// @lc code=end

