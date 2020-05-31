import java.util.HashMap;
import java.util.Map;

/**
* Longest Substring with Same Letters after Replacement (hard)
* 滑动窗口中数据满足条件:
* 窗口大小 -（窗口字母最高频次）<= k (这样可以保证替换后全部相同)
*/

class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart = 0,  windowEnd = 0, maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer>letterFrequencyMap = new HashMap<>();
        for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }


        return Math.min(str.length(), maxRepeatLetterCount + k);
    }
  }