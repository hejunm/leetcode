/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        // <=0的数 n+1;
        int N = nums.length;
        for (int i = 0; i < N; i++){
            if(nums[i] <= 0){
                nums[i] = N + 1;
            }
        }

        // 对应下标标记为负数，标识存在数字：index+1
        for (int i = 0; i < N; i++){
            int index = Math.abs(nums[i]) - 1;
            if(index < N){
                nums[index] = - Math.abs(nums[index]);
            }
        }

        // 查找第一个确实的正数
        for (int i = 0; i < N; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return N+1;
    }
}
// @lc code=end

