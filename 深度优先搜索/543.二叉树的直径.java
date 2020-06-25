/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeMaxDepth(root);
        return diameter;
    }

    private int treeMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = treeMaxDepth(root.left);
        int rightDepth = treeMaxDepth(root.right);

        this.diameter = Math.max(diameter, leftDepth+rightDepth);

        return Math.max(leftDepth, rightDepth)+1;
    }
}

// @lc code=end

