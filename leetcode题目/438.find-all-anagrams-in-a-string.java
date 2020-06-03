import java.util.ArrayList;
import java.util.List;

/*
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (34.12%)
 * Total Accepted:    73.1K
 * Total Submissions: 214.2K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 存放结果
        List<Integer> soln = new ArrayList<>();

        // 数据有效性
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        // 初始化p中字符的hash
        int[] chars = new int[26];
        for (Character c : p.toCharArray()) {
            chars[c - 'a']++;
        }

        int left = 0, right = 0, length = s.length(), count = p.length();
        while (right < length) {
            char rightTemp = s.charAt(right);
            if (chars[rightTemp - 'a'] >= 1) { // rightTemp 在 p中的
                count--;
            }
            chars[rightTemp - 'a']--; // 更新rightTemp 字符可以匹配的数量
            right++;
            if (count == 0) {
                soln.add(left); // wulixiwa, 找到了一个
            }
            if (right - left == p.length()) { // 处理left
                char tempLeft = s.charAt(left);
                if (chars[tempLeft - 'a'] >= 0) { // tempLeft字符对count-- 做出过贡献。还回来。 如果没有做过贡献，应该是负数
                    count++;
                }
                chars[tempLeft - 'a']++;
                left++;
            }
        }
        return soln;
    }
}
