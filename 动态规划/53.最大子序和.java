/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 
 * dp[i]：
 * 以nums[i]结尾的最大子序列和
 * 
 * dp[i]初始值：
 * 子数组最少包含一个元素，则 dp[i] 初始值为 nums[i]
 * 
 * 已知dp[0]..dp[i-1] 如何求出dp[i]:
 * dp[i] = max(dp[i-1]+nums[i], nums[i])
 * 
 * 状态压缩：
 * dp[i]的只依赖dp[i-1]，使用一个变量保存状态即可
 */
class Solution {
    // 状态压缩后的dp
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int preMaxSum = nums[0];
        int result = nums[0]; //结果
        for (int i = 1; i < nums.length; i++) {
            int currentMaxSum =  Math.max(nums[i], preMaxSum+nums[i]);
            result = Math.max(result, currentMaxSum);
            preMaxSum = currentMaxSum;
        }
        return result;
    }
}

/**
public int maxSubArray(int[] nums) {
    if(nums==null || nums.length==0){
        return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int result = dp[0]; //结果

    for (int i = 1; i < nums.length; i++) {
        dp[i] = nums[i];
        dp[i] = Math.max(dp[i], dp[i-1]+nums[i]);
        result = Math.max(result, dp[i]);
    }
    return result;
}
*/

