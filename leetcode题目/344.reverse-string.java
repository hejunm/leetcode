/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (61.06%)
 * Total Accepted:    278K
 * Total Submissions: 455.3K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: "hello"
 * Output: "olleh"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i=0;
        int j = word.length;
        while(i<j){
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
