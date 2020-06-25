/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) { 
        if(root == null){
            return 0;
        }
        path(root);
        return max;
    }

    private int path(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(path(root.left), 0);
        int right = Math.max(path(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(root.val+left, root.val+right);
    }


}

