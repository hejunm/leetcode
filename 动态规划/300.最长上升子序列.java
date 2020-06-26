/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 * 
 * dp[i]： 
 * 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
 * 
 * dp[] 初始值：
 * 全为1
 * 
 * 已知dp[0] ... dp[i-1], 如何求出dp[i]:
    for (int j = 0; j < i; j++) {
        if(nums[j] < nums[i]){
            dp[i] = Math.max(dp[j]+1, dp[i]);
        }
    }
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

