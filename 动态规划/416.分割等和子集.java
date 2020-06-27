/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
/**
问题：
    判断nums[]中是否存在子集，该子集的和为target

状态：
    target：取值范围 [0, sum]
    i：nums[0], nums[1]..nums[i] 这个数组是否存在子集 满足和为target
        取值范围：[0, nums.length-1]

选择：   

dp[i][t] = true | false 定义：
    nums[1]..nums[i] 这个数组是否存在子集， 其和为t

base case:
    dp[..][0] = true, 空数组
    dp[0][t] = nums[0] == t; t范围：[1, target]

状态转移方程：
    dp[i][t] = dp[i-1][t] || dp[i-1][t-nums[i]]
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum+=n;
        }
        if(sum % 2 == 1){
            return false;
        }
        if(sum/2 == 0){
            return true;
        }
        return helper2(nums, sum/2);
    }

    boolean helper(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length][target+1];

        //base case
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int t = 1; t <= target; t++) {
            dp[0][t] = nums[0] == t;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int t = 1; t <= target; t++) {
                if(nums[i] <= t){
                    dp[i][t] = dp[i-1][t] || dp[i-1][t-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }

    /**
     状态压缩
    */
    boolean helper2(int[] nums, int target){
        boolean[] dp = new boolean[target+1];

        //base case
        dp[0] = true;
        for (int t = 1; t <= target; t++) {
            dp[t] = nums[0] == t;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int t = target; t >= 1; t--) { //倒序，解决覆盖问题
                if(t >= nums[i]){
                    dp[t] = dp[t] || dp[t-nums[i]];
                }
            }
        }
        return dp[target];
    } 


}
// @lc code=end

