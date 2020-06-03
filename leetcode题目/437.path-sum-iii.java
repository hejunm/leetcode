import java.util.HashMap;

/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (40.29%)
 * Total Accepted:    66.9K
 * Total Submissions: 166K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 
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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer>preSum = new HashMap<>();
        preSum.put(0, 1);//单个节点的值等于给定的sum。
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root,int currSum,int target,HashMap<Integer,Integer>preSum){
        if(root==null){
            return 0;
        }
        currSum += root.val;
        int result = preSum.getOrDefault(currSum-target, 0); //找出上个节点，满足（currSum-上个节点sum）= target
        preSum.put(currSum, preSum.getOrDefault(currSum, 0)+1);
        result += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum)-1); //一个节点遍历结束后，做清理工作。
        return result;
    }
}
