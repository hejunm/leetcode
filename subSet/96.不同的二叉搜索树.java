/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if(n <= 1){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftCount = numTrees(i-1);
            int rightCount = numTrees(n-i);
            count += (leftCount * rightCount);
        }
        return count;
    }
} 
// @lc code=end

