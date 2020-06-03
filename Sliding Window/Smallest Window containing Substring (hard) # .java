import java.util.HashMap;
import java.util.Map;

/**
Smallest Window containing Substring (hard) #
Given a string and a pattern, 
find the smallest substring in the given string which has all the characters of the given pattern.

Example 1:
Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Example 2:
Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".

Example 3:
Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.

问题:
在给定字符串中查找符合条件的最短子串

窗口条件：
窗口中的子串 has all the characters of the given pattern.
子串中有一个给定的字符集

如何满足条件：

*/

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int subStringStart = 0;
        int minLength = str.length()+1;

        Map<Character, Integer>charFrequencyMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c , charFrequencyMap.getOrDefault(c, 0)+1);
        }

        int windowStart = 0, windowEnd = 0, matched = 0;
        for (; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);
                if (charFrequencyMap.get(rightChar) == 0){
                    matched++;
                }
            }

            //找到一个符合条件的字符串。 缩小找最小子串
            while(matched == charFrequencyMap.size()){
                if (minLength > windowEnd-windowStart+1){
                    minLength = windowEnd-windowStart+1;
                    subStringStart = windowStart;
                }
                char leftChar = str.charAt(windowStart);
                if(charFrequencyMap.containsKey(leftChar)){
                    if (charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }
                windowStart++;
            }
        }
        return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);
    }
  }