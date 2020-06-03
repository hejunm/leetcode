import java.util.HashMap;
import java.util.Map;

/**
Longest Substring with K Distinct Characters (medium)
 * 解决问题：
 * 从数组中查询一个连续子数组
 * 
 * 窗口限制条件：
 * 窗口中不同字符数量 <= k
 * 
 * 如何满足条件：
 * 当窗口中不同字符数量>k时， 缩小窗口，直到满足条件
*/

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
      if (str==null || str.length()==0 || str.length()<k){
        throw new IllegalArgumentException(); 
      }

      int windowStart = 0;
      int winowEnd = 0;
      int maxLength = 0;
      Map<Character, Integer>map = new HashMap<>();
      for (winowEnd = 0; winowEnd < str.length(); winowEnd++) {
          char rightChar = str.charAt(winowEnd);
          map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

          while (map.size() > k) {  //缩小窗口
            char leftChar = str.charAt(windowStart);
            map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
            if (map.getOrDefault(leftChar, 0) == 0) {
                map.remove(leftChar);
            }
            windowStart++;
          }
          maxLength = Math.max(maxLength, winowEnd-windowStart+1);
      }
      return maxLength;
    }
  }