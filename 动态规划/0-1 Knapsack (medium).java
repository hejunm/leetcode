/**

# 0/1 Knapsack (medium)

Given the weights and profits of ‘N’ items, 
we are asked to put these items in a knapsack which has a capacity ‘C’. 
The goal is to get the maximum profit out of the items in the knapsack. 
Each item can only be selected once, as we don’t have multiple quantities of any item.

Example:
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit

设商品数量N

定义dp[i][c]：
    对于前 i 个物品，当前背包的容量为c，这种情况下可以装的最大价值是 dp[i][c]
    i范围 [0, N)； c范围：[0, capacity]

初始值：
    dp[i][0] = 0； i范围 [0, N)； 代表当背包容量为0时，能装的价值都是0。
    dp[0][c] = weights[0] <= c ? profits[0] : 0; c范围：[0, capacity]；

如何利用dp[i-1]求出dp[i]， 即 “状态转移方程是什么？”: 
    两种选择：将物品i放到背包(容量允许的化) | 不放到背包
    int p1 = 0;
    int p2 = 0;
    if(weights[i] >= c){
        p1 = profits[i] + dp[i-1][c-weights[i]]
    }
    p2 = dp[i-1][c]
    dp[i][c] = Math.max(p1, p2);

状态压缩：
    有上述分析，dp[i] 只依赖于 dp[i-1], 可将二维数组压缩为移位数组
*/
class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        //参数校验
        if (profits.length==0 || profits.length != weights.length || capacity==0) {
            return 0;
        }
        int N = profits.length;
        int[][]dp = new int[N][capacity+1];

        //base case, c=0时 价值为0
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        for (int c = 0; c <= capacity; c++) {
            dp[0][c] = weights[0] <= c ? profits[0] : 0;
        }

        //状态i， c
        for (int i = 1; i < N; i++) {
            for (int c = 1; c <= capacity; c++) {
                // 选择：将物品i放到背包(容量允许的化) | 不放到背包
                int p1 = 0;
                int p2 = 0;
                if(weights[i] <= c){
                    p1 = dp[i-1][c-weights[i]] + profits[i];
                }
                p2 = dp[i-1][c];
                dp[i][c] = Math.max(p1, p2);
            }
        }
        return dp[N-1][capacity];
    }

        // 状态压缩
        public int solveKnapsack2(int[] profits, int[] weights, int capacity) {
            //参数校验
            if (profits.length==0 || profits.length != weights.length || capacity==0) {
                return 0;
            }
            int N = profits.length;
            int[]dp = new int[capacity+1];
    
            //base case, c=0时 价值为0
            for (int c = 0; c <= capacity; c++) {
                dp[c] = weights[0] <= c ? profits[0] : 0;
            }
    
            //状态i， c
            for (int i = 1; i < N; i++) {
                //防止dp[i-1] 被 dp[i]覆盖
                for (int c = capacity; c >= 1; c--) {
                    // 选择：将物品i放到背包(容量允许的化) | 不放到背包
                    int p1 = 0;
                    int p2 = 0;
                    if(weights[i] <= c){
                        p1 = dp[c-weights[i]] + profits[i];
                    }
                    p2 = dp[c];
                    dp[c] = Math.max(p1, p2);
                }
            }
            return dp[capacity];
        }
}