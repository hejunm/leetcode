/*
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.04%)
 * Total Accepted:    126K
 * Total Submissions: 340.1K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * n!质因子中5的个数= floor(n / 5) + floor(n / 25) + floor(n / 125) + ....
 * 
 * 1,2,3,4,5,6.....25,26,.... 125...  //每隔5取一个数
 *                 25,50,75...125...  //每隔25取一个数
 * ...........................125...  //每隔125取一个数
 * 
 */
class Solution {
    public int trailingZeroes(int n) {
        int numberOfZero= 0;
        while(n>0){
            numberOfZero += n/5;
            n = n/5;
        }
        return numberOfZero;
    }
}
