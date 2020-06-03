import java.util.Map;

/**
 * No-repeat Substring (hard)
 * Given a string, find the length of the longest substring which has no repeating characters.
 * 
 * 解决问题：
 * 从数组中查询一个连续子串
 * 
 * 窗口限制条件：
 * 无重复字符
 * 
 * 如何满足条件：
 * 窗口右移一位，如果重复，则移动windowStart移除重复项
 * windowStart = Math.max(preSameCharIdnex+1, windowStart)
 * 如果 windowStart=preSameCharIdnex+1， 下面的场景存在bug
 * 
 *        |start  
 * a  b c c b; 
 *          |end (windowStart = Math.max(preSameCharIdnex+1, windowStart))
*/

class NoRepeatSubstring {

  public static int findLength(String str) {
    int windowStart = 0;
    int winowEnd = 0;
    int maxLength = 0;
    Map<Character, Integer>map = new HashMap<>(); //char --> index of char
    for (winowEnd = 0; winowEnd < str.length(); winowEnd++) {
        char rightChar = str.charAt(winowEnd);
        // 处理left，使其满足 窗口中无重复字符;
        int preSameCharIdnex = map.getOrDefault(rightChar, -1);
        if (preSameCharIdnex != -1){
            windowStart = Math.max(preSameCharIdnex+1, windowStart);
            map.remove(rightChar);
        }

        map.put(rightChar, winowEnd);
        maxLength = Math.max(maxLength, winowEnd-windowStart+1);
    }
    return maxLength;
  }

}