/*
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (47.41%)
 * Total Accepted:    150K
 * Total Submissions: 316.5K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        int charCount[] = new int[26];
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-'a']++;
        }
        for(int j=0;j<s.length();j++){
            if(charCount[s.charAt(j)-'a'] == 1){
                return j;
            }
        }
        return -1;
    }
}
