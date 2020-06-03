/*
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (56.45%)
 * Total Accepted:    328.6K
 * Total Submissions: 582K
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 * n^n = 0;
 * 0^n = n;
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
