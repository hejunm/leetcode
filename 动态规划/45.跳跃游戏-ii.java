/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 * 定义：dp[i], 到达 i 最小跳跃次数。
 * 初始化：dp[0] = 0;
 * 状态转移方程：
 *  由 dp[i] --->  min(dp[i+n], dp[i]+1), n取值范围：[1, nums[i]];
 * 返回值：dp[nums.lenth-1]
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 0; i < length-1; i++) {
            int maxDis = nums[i];
            for (int j = 1; j <= maxDis; j++) {
                if(i+j >= length){
                    break;
                }
                if(dp[i+j] == 0){
                    dp[i+j] = dp[i] + 1;
                }else{
                    dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                }
            }
        }
        return dp[length-1];
    }
}
// @lc code=end

