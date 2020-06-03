/*
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (27.98%)
 * Total Accepted:    249.2K
 * Total Submissions: 890.4K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int head = 0;
        int tail = s.length()-1;
        char cHead,cTail;
        while(head<tail){
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if(!Character.isLetterOrDigit(cHead)){
                head ++;
            }else if(!Character.isLetterOrDigit(cTail)){
                tail--;
            }else{
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
