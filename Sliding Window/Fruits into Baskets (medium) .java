import java.util.HashMap;
import java.util.Map;

/**
 * Fruits into Baskets (medium)
 * 找出最长子序列表，最多两个不同的元素
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