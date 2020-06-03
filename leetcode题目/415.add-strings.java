/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (41.89%)
 * Total Accepted:    63.9K
 * Total Submissions: 152.5K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0||cacarry>0;i--,j--){
            int x = i<0?0:num1.charAt(i)-'0';
            int y = j<0?0:num2.charAt(j)-'0';
            int sum = x+y+carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }
}
