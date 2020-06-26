import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */
/**
 * base case: 
 * 总金额为0时，不要选硬币，所选币种个数0
 * 
 * 状态：
 * 总金额0，1，2...amount
 * 
 * 选择：
 * 不同面额的硬币coins，选择哪一个？
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dpArray = new int[amount+1];
        Arrays.fill(dpArray, amount+1);

        dpArray[0] = 0;

        dp(coins, amount, dpArray);

        return dpArray[amount] == amount+1 ? -1 : dpArray[amount];
    }

    private void dp(int[] coins, int amount, int[] dpArray){
        for (int i = 0; i <= amount; i++) { //遍历所有状态的取值
            int minCount = dpArray[i];      // 硬币最少数量
            for (int coin : coins) {        //在所选择中取最小值
                if(coin > i){
                    continue;
                }
                minCount = Math.min(minCount, dpArray[i - coin] + 1);
            }
            dpArray[i] = minCount;
        }
    }
}

