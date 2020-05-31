import javax.swing.tree.TreeNode;

/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (43.20%)
 * Total Accepted:    176.1K
 * Total Submissions: 407.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList,root,0);
        return wrapList;

    }
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level >= list.size()){
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list,root.left,level+1);
        levelMaker(list,root.right,level+1);
        //每个level 对应wrapList中的index.
        int index = list.size()-1-level;
        list.get(index).add(root.val);
    }
}
