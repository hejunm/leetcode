/**
Permutation in a String (hard)

Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
abc、acb、bac、bca、cab、cba

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.

* 解决问题：
从字符串中查找连续子串

* 窗口限制条件
窗口中字符 is permutation of the pattern
窗口中子字符串生成的map map(char, count) 与pattern生成的相同

* 如何满足条件
方法1：当windwodEnd>=pattern.length时，判断子串是否满足条件。
方法2：线性时间时间复杂度。
*/

import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char c : pattern.toCharArray()) {
        charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0)+1);
    }

    int windowStart = 0, windowEnd = 0, matched = 0;
    for (; windowEnd < str.length(); windowEnd++) {
        char rightChar = str.charAt(windowEnd);
        if(charFrequencyMap.containsKey(rightChar)){
            int temp = charFrequencyMap.get(rightChar)-1;
            charFrequencyMap.put(rightChar, temp);
            if(temp == 0){
                matched++;
            }
            if (matched == charFrequencyMap.size()) {
                return true;
            }
        }
        if (windowEnd >= pattern.length()-1){
            //滑动窗口长度与pattern长度相同，但是不符合条件。移动windowStart
            char leftChar = str.charAt(windowStart);
            if (charFrequencyMap.containsKey(leftChar)){
                int temp = charFrequencyMap.get(leftChar);
                if (temp==0){
                    matched--;
                }
                charFrequencyMap.put(leftChar, temp+1);
            }
            windowStart++;
        }
    }
    return false;
  }
}