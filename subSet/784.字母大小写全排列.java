import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 *  回溯法
 */

// @lc code=start

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder());
        
        char[] chars = S.toCharArray();
        for (char c : chars) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder oldString = queue.poll();
                if('0' <=c && c <= '9' ){
                    oldString.append(c);
                    queue.add(oldString);
                }else{
                    StringBuilder upperCase = new StringBuilder(oldString);
                    upperCase.append(Character.toUpperCase(c));
                    queue.add(upperCase);

                    StringBuilder lowerCase = new StringBuilder(oldString);
                    lowerCase.append(Character.toLowerCase(c));
                    queue.add(lowerCase);
                }
            }
        }

        for (StringBuilder sb : queue) {
            result.add(sb.toString());
        }
        return result;
    }
}


// class Solution {
//     public List<String> letterCasePermutation(String S) {
//         List<String> result = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         backtracking(S, result, sb);
//         return result;
//     }

//     private void backtracking(String s, List<String>result, StringBuilder sb){
//         int sLength = s.length();
//         int sbLength = sb.length();
//         if(sLength == sbLength ){
//             result.add(sb.toString());
//             return;
//         }
//         char c = s.charAt(sbLength);
//         if('0' <= c && c <= '9' ){
//             sb.append(c);
//             backtracking(s, result, sb);
//             sb.deleteCharAt(sb.length()-1);
//         }else{
//             sb.append(Character.toUpperCase(c));
//             backtracking(s, result, sb);
//             sb.deleteCharAt(sb.length()-1);

//             sb.append(Character.toLowerCase(c));
//             backtracking(s, result, sb);
//             sb.deleteCharAt(sb.length()-1);
//         }
//     }
// }
// @lc code=end

