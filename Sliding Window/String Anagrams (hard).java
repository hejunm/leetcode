import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
String Anagrams (hard) #
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
abc、acb、bac、bca、cab、cba

Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

问题：
与Permutation in a String (hard) 基本一致。
找出所有符合条件的连续子序列

窗口满足的条件：
窗口中字符 is permutation of the pattern
窗口中子字符串生成的map map(char, count) 与pattern生成的相同
**/

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    
    Map<Character, Integer>charFrequencyMap = new HashMap<>();
    for (char c : pattern.toCharArray()) {
        charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0)+1);
    }

    int windowStart = 0, windowEnd = 0, matched = 0;
    for (; windowEnd < str.length(); windowEnd++) {
        char rightChar = str.charAt(windowEnd);
        if (charFrequencyMap.containsKey(rightChar)){
            charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);
            if (charFrequencyMap.get(rightChar) == 0){
                matched++;
            }
            if (matched == charFrequencyMap.size()){
                resultIndices.add(windowStart);
            }
        }

        //处理窗口的windowLeft
        if(windowEnd >= pattern.length()-1){
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
    return resultIndices;
  }
}
