# 深度优先搜索

## 介绍

* [wiki](https://zh.wikipedia.org/wiki/%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2)
* 一种用于遍历或搜索树或图的算法。
* 这个算法会尽可能深的搜索树的分支。当节点v的所在边都己被探寻过，搜索将回溯到发现节点v的那条边的起始节点。这一过程一直进行到已发现从源节点可达的所有节点为止。
* 如果还存在未被发现的节点，则选择其中一个作为源节点并重复以上过程，整个进程反复进行直到所有节点都被访问为止。
* 要实现回溯到上个节点，需记录遍历节点的轨迹。 可通过两种方式实现： 递归、 栈。 空间复杂度为 O(H)， H为树高.

## 解题方法 & 代码模板

``` java
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}
```

## 例题

* [112.路径总和](./112.路径总和.java)
* [113.路径总和-ii](./113.路径总和-ii.java)
* [124.二叉树中的最大路径和](./124.二叉树中的最大路径和.java)
* [129.求根到叶子节点数字之和](./129.求根到叶子节点数字之和.java)
* [437.路径总和-iii](./437.路径总和-iii.java)
* [543.二叉树的直径](./543.二叉树的直径.java)
* [Path With Given Sequence (medium)](./Path&#32;With&#32;Given&#32;Sequence&#32;(medium).java)

<!-- * [112. 路径总和](https://leetcode-cn.com/problems/path-sum/description/)
* [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)
* [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
* [129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)
* [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/description/)
* [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/) -->
