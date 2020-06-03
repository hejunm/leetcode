import javax.swing.tree.TreeNode;

/*
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (38.92%)
 * Total Accepted:    242.9K
 * Total Submissions: 624K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * Return false.
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
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    
    //深度
    int dfsHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if(leftHeight==-1){                     //上报
            return -1;
        }
        int rightHeight = dfsHeight(root.right);
        if(rightHeight==-1){                    //上报
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){ //子树已经不平衡了
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
