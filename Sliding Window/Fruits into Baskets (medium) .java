import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * https://leetcode-cn.com/problems/fruit-into-baskets/
 * 904. Fruit Into Baskets
 * 解决问题：
 * 从数组中查询一个连续子数组
 * 
 * 窗口限制条件：
 * 窗口中 不同字符数量<=2
 * 
 * 如何满足条件：
 * 当 不同字符数量>2时， 缩小窗口，直到满足条件
*/

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        final int k = 2;
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;

        Map<Character,Integer> map = new HashMap<>();
        for (; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
            while(map.size() > k){
                char leftChar = arr[windowStart];
                map.put(leftChar, map.getOrDefault(leftChar, 0)-1);
                if ( map.getOrDefault(leftChar, 0) == 0){
                    map.remove(leftChar);
                }
                windowStart ++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
  }