import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Words Concatenation (hard) #

Given a string and a list of words, 
find all the starting indices of substrings in the given string 
that are a concatenation of all the given words exactly once without any overlapping of words. 
It is given that all words are of the same length.

Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".

问题：
从字符串中找出所有符合条件的子串

窗口满足条件：
子串分割出单词，各单词出现次数 与 words中单词出现次数相同
 * 
*/

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        int wordCount = words.length;
        int wordLength = words[0].length();
        Map<String, Integer>wordFrequencyMap = new HashMap<>();
        List<Integer> resultIndices = new ArrayList<Integer>();

        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0)+1);
        }
        
        for (int i = 0; i <= str.length()-wordCount*wordLength; i++) {
            Map<String, Integer>wordsSeen = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int wordIndex = i+j*wordLength;
                String word = str.substring(wordIndex, wordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)){
                    break;
                }
                int wordSeenCount =  wordsSeen.getOrDefault(word, 0)+1;
                if (wordSeenCount > wordFrequencyMap.get(word)){
                    break;
                }
                wordsSeen.put(word, wordSeenCount);

                if (j + 1 == wordCount){
                    resultIndices.add(i);
                }
            }
        }
      return resultIndices;
    }
  }