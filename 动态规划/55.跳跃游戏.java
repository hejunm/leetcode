/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        //定义dp[i], 是否可以跳到 下标为i的位置
        //初始条件 dp[0] = true;
        //状态转移方程： 如果可以到达dp[i]，则 也可以到达 dp[i+1]...do[i+nums[i]];

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i] == false){
                continue;
            }
            int maxLength = nums[i];
            for (int j = 1; j <= maxLength && i+j<nums.length; j++) {
                dp[i+j] = true;
            }
        }
        return dp[nums.length-1];
    }
}
// @lc code=end

