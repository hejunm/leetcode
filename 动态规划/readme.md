# 背包算法 | 动态规划算法（(Dynamic Programming）

## 概念

### 自顶向下

* 从规模大的原问题 向下逐渐分解为子问题。一般使用递归完成
* 例如 “斐波那契数列”
  
```c++
int fib(int N) {
if (N < 1) return 0;
// 备忘录全初始化为 0
vector<int> memo(N + 1, 0);
// 进行带备忘录的递归
return helper(memo, N);
}

int helper(vector<int>& memo, int n) {
    // base case
    if (n == 1 || n == 2) return 1;
    // 已经计算过
    if (memo[n] != 0) return memo[n];
    memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
    return memo[n];
}
```

### 自底向上（动态规划）

* 先从底部开始求子问题的解，在子问题解基础上 向上计算直到获得结果
* 使用dp数组保存所有子问题的解
* 例如 “斐波那契数列”

```c++
int fib(int N) {
    vector<int> dp(N + 1, 0);
    // base case
    dp[1] = dp[2] = 1;
    for (int i = 3; i <= N; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
    return dp[N];
}
```

### 0/1背包

* 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
* 这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。
* 用子问题定义状态：即f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：
* f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
* [详解](https://www.kancloud.cn/kancloud/pack/70125)

### 完全背包问题

* 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
* 这个问题非常类似于01背包问题，所不同的是每种物品有无限件。也就是从每种物品的角度考虑，与它相关的策略已并非取或不取两种，而是有取0件、取1件、取2件……等很多种。如果仍然按照解01背包时的思路，令f[i][v]表示前i种物品恰放入一个容量为v的背包的最大权值。仍然可以按照每种物品不同的策略写出状态转移方程，像这样：
* f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k*c[i]<=v}
* [详细](https://www.kancloud.cn/kancloud/pack/70126)

### 最优子结构

* 动态规划一般是求最值，通过过子问题的最优解(最优子结构) 推到出原问题的最优解

## 解题步骤

### 确定状态转移方程（描述问题结构的数学形式）

* 从状态1 如何推导出 状态2？
* 明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。

1. 确定「状态」，也就是原问题和子问题中会变化的变量。
2. 确定「选择」，也就是导致「状态」产生变化的行为。
3. 明确dp数组的定义
4. 指定dp数组的base case
5. 找出状态转移方程 （已知dp[0]..dp[i-1], 如何求出dp[i]）

### DP表设计

* dp[状态1][状态2][...] = 最优解
* 明确 dp 数组所存数据的含义。这一步对于任何动态规划问题都很重要，如果不得当或者不够清晰，会阻碍之后的步骤。
* 根据 dp 数组的定义，运用数学归纳法的思想，假设 dp[0...i-1] 都已知，想办法求出 dp[i]，一旦这一步完成，整个题目基本就解决了。

### 重复子问题 & 时间复杂度的优化

* 由于存在重复子问题，相同子问题多次计算，效率低
* 使用「DP table」存储子问题结果

### 状态压缩 & 空间复杂度优化

* 分析DP表，根据DP表数据的使用情况 考虑状态压缩。
* 以“斐波那契数列”为例， dp[i] = dp[i - 1] + dp[i - 2];  状态i的值由状态i-1， i-2组成，所以可以将dp数组压缩为两个变量。节省内存空间

## 代码模板

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

* [0-1 Knapsack (medium)](./0-1&#32;Knapsack&#32;(medium).java)
* [53.最大子序和](./53.最大子序和.java)
* [300.最长上升子序列](./300.最长上升子序列.java)
* [322.零钱兑换](./322.零钱兑换.java)
* [416.分割等和子集](./416.分割等和子集.java)
* [518.零钱兑换-ii](./518.零钱兑换-ii.java)

* [leetcode 题目汇总](https://leetcode-cn.com/tag/dynamic-programming/)
* [72.编辑距离](https://leetcode-cn.com/problems/edit-distance/)
* [300.最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
* [322.零钱兑换](https://leetcode-cn.com/problems/coin-change/)
* [416.分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
* [509.斐波那契数0](https://leetcode-cn.com/problems/fibonacci-number/)
* [518.零钱兑换II](https://leetcode-cn.com/problems/coin-change-2/)
* [887.鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)

## 参考资料

* [资料](https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie)
* [背包问题九讲](https://www.kancloud.cn/kancloud/pack/70125)
