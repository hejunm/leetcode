/*
 * [191] Number of 1 Bits
 *
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * algorithms
 * Easy (40.73%)
 * Total Accepted:    207.8K
 * Total Submissions: 510.2K
 * Testcase Example:  '           0 (00000000000000000000000000000000)'
 *
 * Write a function that takes an unsigned integer and returns the number of
 * '1' bits it has (also known as the Hamming weight).
 * 
 * Example 1:
 * 
 * 
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation
 * 00000000000000000000000000001011 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation
 * 00000000000000000000000010000000
 * 
 * 
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int value = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                value++;
            }
            mask <<= 1;
        }
        return value;
    }

    //more faster!
    private int anotherMethod(int n){
        int sum = 0;
        while(n != 0){
            sum ++;
            n &= (n-1);
        }
        return sum;
    }
}
