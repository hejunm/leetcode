/**
 * Minimum Depth of a Binary Tree (easy)
Find the minimum depth of a binary tree. 
The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.

example:
    1
 2,    3
4,5,

2
*/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class MinimumBinaryTreeDepth {
    
    public static int findDepth(TreeNode root) {
        int depth = 0;

        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.offer(root);
        }
        
        while (!q.isEmpty()) {
            depth++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null){
                    return depth;
                }

                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return depth;
    }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}

