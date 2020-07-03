# BFS

## 介绍

* [解题思路](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/bfs-kuang-jia)
* 广度优先搜索， 借助queue，一层层的遍历图

## 解题方法 & 代码模板

```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}

void BFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if(root != null){
        queue.offer(root);
    }
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.offer(cur.left);
            }
            if(current.right != null){
                queue.offer(cur.right);
            }
            //逻辑处理
        }
    }
}
```

## 例题

* [Binary Tree Level Order Traversal (easy)](./Binary&#32;Tree&#32;Level&#32;Order&#32;Traversal&#32;(easy).java)
* [Connect All Level Order Siblings (medium) #](./Connect&#32;All&#32;Level&#32;Order&#32;Siblings&#32;(medium)&#32;#&#32;.java)
* [Connect Level Order Siblings (medium)](./Connect&#32;Level&#32;Order&#32;Siblings&#32;(medium)&#32;.java)
* [Minimum Depth of a Binary Tree (easy)](./Minimum&#32;Depth&#32;of&#32;a&#32;Binary&#32;Tree&#32;(easy)&#32;.java)
* [Reverse Level Order Traversal (easy)](./Reverse&#32;Level&#32;Order&#32;Traversal&#32;(easy).java)
* [Right View of a Binary Tree (easy) #](./Right&#32;View&#32;of&#32;a&#32;Binary&#32;Tree&#32;(easy)&#32;#.java)
* [Zigzag Traversal (medium)](./Zigzag&#32;Traversal&#32;(medium).java)
* [111.二叉树的最小深度](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
* [752.打开转盘锁](https://leetcode-cn.com/problems/open-the-lock/)
