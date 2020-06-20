# 背包算法 | 动态规划算法（(Dynamic Programming）

## 介绍

* 状态转移方程
* 重叠子问题
  * 需要「备忘录」或者「DP table」来优化穷举过程
* 最优子结构
* 状态压缩
* 自顶向下 (递归、备忘录)
* 自底向上（DP）
  1. 明确 dp 数组所存数据的含义。这一步对于任何动态规划问题都很重要，如果不得当或者不够清晰，会阻碍之后的步骤。
  2. 根据 dp 数组的定义，运用数学归纳法的思想，假设 dp[0...i-1] 都已知，想办法求出 dp[i]，一旦这一步完成，整个题目基本就解决了。

## 解题方法 & 代码模板

```java
// 初始化 base case
dp[0][0][...] = base
// 进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)

// https://leetcode-cn.com/problems/coin-change/
// 例如 凑硬币
int coinChange(vector<int>& coins, int amount) {
    // 数组大小为 amount + 1，初始值也为 amount + 1
    vector<int> dp(amount + 1, amount + 1);
    // base case
    dp[0] = 0;
    // 外层 for 循环在遍历所有状态的所有取值
    for (int i = 0; i < dp.size(); i++) {
        // 内层 for 循环在求所有选择的最小值
        for (int coin : coins) {
            // 子问题无解，跳过
            if (i - coin < 0) continue;
            dp[i] = min(dp[i], 1 + dp[i - coin]);
        }
    }
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
}
```

## 题目

* [解题思路](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie)
* [题目汇总](https://leetcode-cn.com/tag/dynamic-programming/)
* [300.最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
* [509.斐波那契数0](https://leetcode-cn.com/problems/fibonacci-number/)
* [322.零钱兑换](https://leetcode-cn.com/problems/coin-change/)
* [416.分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
* [518.零钱兑换II](https://leetcode-cn.com/problems/coin-change-2/)
* [72.编辑距离](https://leetcode-cn.com/problems/edit-distance/)
* [887.鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)
  