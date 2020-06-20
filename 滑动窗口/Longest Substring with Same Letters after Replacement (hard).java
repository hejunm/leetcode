import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with Same Letters after Replacement (hard)
 * Given a string with lowercase letters only,  if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement.
 * 解决问题：
 * 找到最大连续子串
 * 
 * 窗口限制条件：
 * 字符出现的最高频次 + k <= 窗口大小
 * 
 * 如何满足条件：
 * 不满足条件是 缩小窗口
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