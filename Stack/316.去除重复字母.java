import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 * 
 * 单调栈
 * 
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {

        char[] cArray = s.toCharArray();

        Deque<Character> stack = new LinkedList<>();
        HashSet<Character> seen = new HashSet<>(); //栈中存在的字符
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < cArray.length; i++) {
            last_occurrence.put(cArray[i], i);
        }

        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if(seen.contains(c)){
               continue;
            }
             //栈顶topC > c &&  后序还存在 topC 那么topC出栈
             while(!stack.isEmpty() && stack.peek() > c && last_occurrence.get(stack.peek()) > i){
                seen.remove(stack.pop());
            }
            seen.add(c);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

