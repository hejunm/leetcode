/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int rootToCurrentSum = sum*10 + root.val;
        if(root.left==null && root.right==null){ //叶子节点
            return rootToCurrentSum;
        }
        return helper(root.left, rootToCurrentSum) + helper(root.right, rootToCurrentSum);
    }
}
// @lc code=end

