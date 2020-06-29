import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

class ParenthesesString{
    int openCount;
    int closeCount;
    String string;

    public ParenthesesString(String string, int openCount, int closeCount){
        this.openCount = openCount;
        this.closeCount = closeCount;
        this.string = string;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();

        queue.add(new ParenthesesString("", 0, 0));

        while(queue.isEmpty() == false){
            ParenthesesString oldParent = queue.poll();
            if(oldParent.openCount==n && oldParent.closeCount==n){
                result.add(oldParent.string);
            }else{
                if(oldParent.openCount < n){
                    queue.add(new ParenthesesString(oldParent.string + '(', oldParent.openCount+1, oldParent.closeCount));
                }
                if(oldParent.openCount > oldParent.closeCount){
                    queue.add(new ParenthesesString(oldParent.string + ')', oldParent.openCount, oldParent.closeCount+1));
                }
            }
        }
        return result;
    }
}
// @lc code=end

