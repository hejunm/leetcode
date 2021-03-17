import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 中序遍历, 单调递增
 */
class Solution {
    int currentValue;
    int currentValueCount = 0;
    int maxCount = 0;
    ArrayList<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            mode[i] = result.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int value) {
        if(value == this.currentValue) {
            this.currentValueCount++;
        } else {
            this.currentValue = value;
            this.currentValueCount = 1;
        }
        
        if (this.currentValueCount == this.maxCount) {
            this.result.add(this.currentValue);
        } else if (this.currentValueCount > this.maxCount) {
            this.maxCount = this.currentValueCount;
            this.result.clear();
            this.result.add(this.currentValue);
        }
    }
}
// @lc code=end

