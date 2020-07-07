/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int twoNumsDiff = 0;
        for (int num : nums) {
            twoNumsDiff ^= num;
        }

        // 要查找的两个数的这一位不同。一个1 另一个0
        int firstRightBit = twoNumsDiff & (-twoNumsDiff); 
        int num1 = 0, num2 = 0;

        for (int num : nums) {
            if((firstRightBit & num) == 0){
                num1 ^= num;
            }else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
// @lc code=end

