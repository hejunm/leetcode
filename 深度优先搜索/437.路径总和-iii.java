import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
 * 
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer>pathSumMap = new HashMap<>();
        pathSumMap.put(0, 1);
        return helper(root, sum, 0, pathSumMap);
    }

    /**
     * root:当前节点
     * sum: 期望
     * pathSum: 从根节点到当前节点
     * pathSumMap: 和特定值得数量
    */
    private int helper(TreeNode root, int target, int pathSum, Map<Integer,Integer>pathSumMap){
        if(root == null){
            return 0;
        }
        pathSum += root.val;
        int result = pathSumMap.getOrDefault(pathSum-target, 0);
        pathSumMap.put(pathSum,  pathSumMap.getOrDefault(pathSum, 0)+1);

        result += helper(root.left, target, pathSum, pathSumMap);
        result += helper(root.right, target, pathSum, pathSumMap);

        //恢复现场
        pathSumMap.put(pathSum,  pathSumMap.getOrDefault(pathSum, 0)-1);

        return result;
    }
}
// @lc code=end

