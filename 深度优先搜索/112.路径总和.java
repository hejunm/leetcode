
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        int currentSum = sum - root.val;
        if(root.left==null && root.right==null && currentSum==0){   //叶子节点，并且sum减到0
            return true;
        }
        return hasPathSum(root.left,currentSum) || hasPathSum(root.right,currentSum);
    }
}

