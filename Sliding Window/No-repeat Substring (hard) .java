import java.util.Map;

/**
 * No-repeat Substring (hard)
 * Given a string, find the length of the longest substring which has no repeating characters.
 * 
 * 窗口内需要满足的条件: 无重复字符 
 * 窗口right+1后，需要处理left，使其满足上述条件;
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