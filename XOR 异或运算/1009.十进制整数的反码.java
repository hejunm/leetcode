/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 * 
 * N 与 对应位数的1异或，得到反码
 * "101" ^ “111” = "O10"
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int N) {
        int all_bits_set = 1;
        while(all_bits_set < N){
            all_bits_set = (all_bits_set << 1) + 1;
        }
        return N ^ all_bits_set;
    }
}
// @lc code=end

