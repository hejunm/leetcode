/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
/**

完全背包问题
1 状态：
    总金额
    币种数量

2 选择：
    是否添加币种 coins[i]?

3 定义dp[i][a]：
    使用0...i种币种，凑成总金额a 多少中组合

4 初始值：
    dp[..][0] = 0 //总金额为0， 这个方式都是 1。一个不选
    dp[0][a] = dp[0][c-coins[0]] | 0

5 如何利用dp[i-1]求出dp[i]， 即 “状态转移方程是什么？”: 
    dp[i][a] = dp[i-1][a] + dp[i][c-coins[i]]
    dp[i-1][a]: 不选coins[i]
    dp[i][c-coins[i]]: 选coins[i]
  

状态压缩：
*/
class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length == 0){
            return 0;
        }

        int[][] dp = new int[coins.length][amount+1];

        //base case
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int a = 1; a <= amount; a++) {
            if(coins[0] <= a){
                dp[0][a] = dp[0][a-coins[0]];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int a = 1; a <= amount; a++) {
                if(coins[i] <= a){
                    dp[i][a] = dp[i-1][a] + dp[i][a-coins[i]];
                }else{
                    dp[i][a] = dp[i-1][a];
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}
// @lc code=end

