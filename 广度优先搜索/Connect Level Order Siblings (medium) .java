/**
 * Connect Level Order Siblings (medium)
Given a binary tree, connect each node with its level order successor. 
The last node of each level should point to a null node.
*/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }

  // level order traversal using 'next' pointer
  void printLevelOrder() {
    TreeNode nextLevelRoot = this;
    while (nextLevelRoot != null) {
      TreeNode current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};

class ConnectLevelOrderSiblings {

    public static void connect(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode preNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(preNode != null){
                    preNode.next = current;
                }
                preNode = current;

                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
