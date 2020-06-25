import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, result);
        return result;
    }

    private void pathSum(TreeNode root, int sum,  Deque<Integer> path, List<List<Integer>>result){
        if(root == null){
            return;
        }

        path.addLast(root.val);
        int currentSum = sum - root.val;

        if(root.left == null && root.right==null && currentSum==0){ //叶子节点
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        
        pathSum(root.left, currentSum, path, result);
        pathSum(root.right, currentSum, path, result);
        path.removeLast();
    }
}
// @lc code=end

